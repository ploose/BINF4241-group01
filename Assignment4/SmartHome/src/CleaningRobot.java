import java.text.DecimalFormat;
import java.util.Scanner;

public class CleaningRobot implements ICleaningRobot, Runnable {
    private boolean turnedOn = true, isCleaning = false;
    private double requiredTime = 0, elapsedTime = 0;
    private int battery = 100;
    private final int chargeCycle = 100, dischargeCycle = 500;
    private final Object lock = new Object();
    private Scanner input;
    private String[] optionsOn = {"start","set timer", "get progress", "get battery", "stop"};

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

    @Override
    public void setTimer(int time) {
        synchronized (lock) {
            if (!isCleaning) { // TODO: should it be possible to alter time while in base?
                this.requiredTime = time;
                this.elapsedTime = 0;
            } else {
                System.out.println("Can't set timer while cleaning!");
            }
        }
    }

    @Override
    public double getProgress() {
        synchronized (lock) {
            if (requiredTime == 0) {
                return 1;
            } else if (turnedOn) {
                return elapsedTime / requiredTime;
            }

            return -1; // TODO: check turnedOn in phone?
        }
    }

    @Override
    public int getBattery() {
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
                if(requiredTime > 0 && requiredTime == elapsedTime){
                    System.out.println("Robot already finished cleaning.");

                }else if(isCleaning){
                    System.out.println("Robot is already cleaning.");

                } else if (requiredTime > 0 && battery == 100) {
                    // System.out.println("Robot started cleaning.");
                    isCleaning = true;
                    return true;
                } else if (battery < 100){
                    System.out.println("Cleaning Robot is not fully charged!");
                }else if(requiredTime == 0){
                    System.out.println("Cleaning Robot has no set timer");
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

    public String[] getOptions(){
        return optionsOn;
    }

    @Override
    public String[] execute(String decision) {
        switch (decision) {
            case "start":
                if (start()) {
                    System.out.println("Robot started. ");
                }
                break;

            case "set timer":
                System.out.print("Choose a time: ");
                setTimer(input.nextInt());
                break;

            case "get progress":
                double percentage = getProgress()*100;
                DecimalFormat df = new DecimalFormat("#.##"); // trim to 2 decimal places
                percentage = Double.parseDouble(df.format(percentage));

                if (getProgress() >= 0) {
                    System.out.println("The robot has completed " + (percentage) + "% of the cleaning.");
                }
                break;

            case "get battery":
                System.out.println("The robot has " + getBattery() + "% remaining battery charge.");
                break;

            case "stop":
                interruptProgram();
                System.out.println("The program has been interrupted & reset. Robot is returning to station.");
                break;

            default:
                System.out.println("Wrong Input");

        }
        return null;
    }

    @Override
    public boolean isActive() {
        if(turnedOn){
            return true;
        }
        return false;
    }

    public String toString() {
        if (isCleaning) {
            return "The cleaning robot is on and running.";
        }

        else {
            return "The cleaning robot is on.";
        }
    }
}
