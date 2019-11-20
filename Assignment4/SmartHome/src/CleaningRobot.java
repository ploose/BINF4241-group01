import java.text.DecimalFormat;
import java.util.Scanner;

public class CleaningRobot implements ICleaningRobot, Runnable {
    private boolean turnedOn = false, isCleaning = false;
    private double requiredTime = 0, elapsedTime = 0;
    private int battery = 100;
    private final int chargeCycle = 100, dischargeCycle = 500;
    private final Object lock = new Object();
    private Scanner input;

    private volatile static CleaningRobot uniqueInstance;
    private volatile static Thread uniqueThread;

    private CleaningRobot() {
        input = new Scanner(System.in);
    }

    static CleaningRobot getInstance() {
        if (uniqueInstance == null) {
            synchronized (CleaningRobot.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new CleaningRobot();
                    uniqueThread = new Thread(uniqueInstance, "Robot Thread");
                    uniqueThread.start();
                }
            }
        }
        return uniqueInstance;
    }

    public void run() {
        for (; ; ) {
            if (turnedOn) {
                // System.out.print(".");

                // shouldn't do this automatically!
//                if (battery == 100 && elapsedTime < requiredTime) { // restart if charged but not finished
//                    synchronized (lock) {
//                        isCleaning = true;
//                    }
//                } else if ....

                if (elapsedTime >= requiredTime) { // go back to charging station when done
                    synchronized (lock) {
                        isCleaning = false;
                    }
                }

                if (isCleaning && battery > 0) { // Discharging while battery left and cleaning
                    try {
                        Thread.sleep(dischargeCycle);
                        synchronized (lock) {
                            if (battery > 0) {
                                elapsedTime += ((double) dischargeCycle / 1000);
                                battery--;
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (battery < 100) { // Charging in base
                    isCleaning = false;
                    try {
                        Thread.sleep(chargeCycle);
                        synchronized (lock) {
                            if (battery < 100) {
                                battery++;
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //TODO: start() / completeOutstanding() method?

    @Override
    public boolean switchOn() {
        if (!turnedOn) {
            synchronized (lock) {
                turnedOn = true;
                return true;
            }
        }
        System.out.println("Robot is already on.");
        return false;

    }

    @Override
    public void setTimer(int timeInSeconds) {
        synchronized (lock) {
            if (!isCleaning) { // TODO: should it be possible to alter time while in base?
                this.requiredTime = timeInSeconds;
                this.elapsedTime = 0;
            } else {
                System.out.println("Can't set timer while cleaning!");
            }
        }
    }

    @Override
    public double checkProgress() {
        synchronized (lock) {
            if (requiredTime == 0) {
                return 1;
            } else if (turnedOn) {
                double progress = elapsedTime / requiredTime;

                int temp = (int) (progress * 100.0);
                return ((double) temp) / 100.0;

            }

            return -1; // TODO: check turnedOn in phone?
        }
    }

    @Override
    public int checkBattery() {
        synchronized (lock) {
            if (turnedOn) {
                int tmp = battery;
                return tmp;
            }

            return -1; // TODO: check turnedOn in phone?
        }
    }

    @Override
    public boolean start() {
        synchronized (lock) {
            if (turnedOn) {
                if (requiredTime > 0 && battery == 100) {
                    isCleaning = true;
                    return true;
                } else {
                    System.out.println("Cleaning Robot has no set timer or is not fully charged!");
                }
            }
            return false;
        }
    }

    @Override
    public void interruptProgram() { // TODO: Also turnedOn = false?
        if (turnedOn) {
            synchronized (lock) {
                this.requiredTime = 0;
                this.elapsedTime = -((double) dischargeCycle / 1000); // TODO: fix?
                this.isCleaning = false;
            }
        }
    }

    @Override
    public boolean switchOff() {
        turnedOn = false;
        return true;
    }

    @Override
    public void execute() {

        if (!turnedOn) {
            System.out.println("The device is turned off.");
        } else {
            System.out.println("You can choose following functions: ");
            System.out.print("- start(1) \n- set timer (2) \n- check progress (3) \n- check battery (4) \n");
            System.out.print("- reset (5) \n -exit (6)");

            String decision = input.next();

            switch (decision) {
                case "1":
                    if (start()) {
                        System.out.print("Robot started.");
                    }
                    execute();

                case "2":
                    System.out.print("Choose a time: ");
                    setTimer(input.nextInt());
                    execute();

                case "3":
                    double progress = checkProgress();

                    if (checkProgress() >= 0) {
                        System.out.println("The robot has completed " + (progress * 100) + "% of the cleaning.");
                    }

                    execute();

                case "4":
                    System.out.println("The robot has " + checkBattery() + "% remaining battery charge.");
                    execute();

                case "5":
                    interruptProgram();
                    System.out.println("The program has been interrupted & reset. Robot is returning to station.");
                    execute();

                case "6":
                    System.out.println("Returning to main menu.");

                default:
                    System.out.println("Wrong Input");
                    execute();
            }

        }
    }

    public String toString() {
        //TODO
        return "";
    }
}
