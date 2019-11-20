import java.util.Scanner;

public class CleaningRobot implements ICleaningRobot, Runnable {
    private boolean turnedOn = false, isCleaning = false;
    private double requiredTime = 0, elapsedTime = 0;
    private int battery = 100;
    private final int chargeCycle = 100, dischargeCycle = 500;
    private final Object lock = new Object();
    private Scanner input;

    private volatile static CleaningRobot uniqueInstance;

    private CleaningRobot() {
        input = new Scanner(System.in);
    }

    static CleaningRobot getInstance() {
        if (uniqueInstance == null) {
            synchronized (CleaningRobot.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new CleaningRobot();
                }
            }
        }
        return uniqueInstance;
    }

    public void run() {
        for (; ; ) {
            if (turnedOn) {
                if (battery == 100 && elapsedTime < requiredTime) {
                    synchronized (lock) {
                        isCleaning = true;
                    }
                }

                else if (elapsedTime >= requiredTime) {
                    synchronized (lock) {
                        isCleaning = false;
                    }
                }

                if (isCleaning && battery > 0) { // Discharging
                    try {
                        Thread.sleep(dischargeCycle);
                        synchronized (lock) {
                            if (battery > 0) {
                                elapsedTime += ((double) dischargeCycle / 1000);
                                battery--;
                            }
                        }
                    }

                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                else if (battery < 100) { // Charging
                    isCleaning = false;
                    try {
                        Thread.sleep(chargeCycle);
                        synchronized (lock) {
                            if (battery < 100) {
                                battery++;
                            }
                        }
                    }

                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            else {
                try {
                    Thread.sleep(10);
                }

                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //TODO: start() / completeOutstanding() method?

    @Override
    public boolean switchOn() {
        if (requiredTime > 0 && battery == 100) {
            turnedOn = true;
            return true;
        }

        else {
            System.out.println("Cleaning Robot has no set timer / is not fully charged!");
            return false;
        }
    }

    @Override
    public void setTimer(int timeInSeconds) {
        synchronized (lock) {
            if (!isCleaning) { // TODO: should it be possible to alter time while in base?
                this.requiredTime = timeInSeconds;
                this.elapsedTime = 0;
            }

            else {
                System.out.println("Can't set timer while cleaning!");
            }
        }
    }

    @Override
    public double checkProgress() {
        synchronized (lock) {
            if (requiredTime == 0) {
                return 1;
            }

            if (turnedOn) {
                return elapsedTime / requiredTime;
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
        }

        else {
            System.out.println("You can choose following functions: ");
            System.out.print("-set timer (1) \n -check progress (2) \n -check battery (3) \n");
            System.out.print("-reset (4) \n -exit (5)");

            String decision = input.next();

            switch (decision) {
                case "1":
                    System.out.print("Choose a time: ");
                    setTimer(input.nextInt());
                    execute();

                case "2":
                    double progress = checkProgress();

                    if (checkProgress() >= 0) {
                        System.out.println("The robot has completed " + (progress * 100) + "% of the cleaning.");
                    }

                    execute();

                case "3":
                    System.out.println("The robot has " + checkBattery() + "% remaining battery charge.");
                    execute();

                case "4":
                    interruptProgram();
                    System.out.println("The program has been interrupted & reset. Robot is back in station.");
                    execute();

                case "5":
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
