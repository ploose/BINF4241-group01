import java.util.Scanner;

public class Oven implements IOven {

    private boolean turnedOn;
    private int temperature;
    private Program program;
    private boolean cooking;
    private TimerThread timer;
    private Scanner input;
    int time;
    private Smartphone huawei;
    //private String[] options = {"switch on", "switch off", "set temperature", "get timer", "choose program", "start", "exit"};
    private String[] optionsOn = {"switch off", "set temperature", "get timer", "choose program", "start", "exit"};
    private String[] optionsOff = {"switch on"};
    // TODO; lists for switched on/off


    private static Oven uniqueInstance;

    private Oven(Smartphone huawei) {
        program = null;
        temperature = 0;
        turnedOn = false;
        cooking = false;
        timer = new TimerThread(0);
        input = new Scanner(System.in);
        this.huawei = huawei;
    }

    static Oven getUniqueInstance(Smartphone huawei) {
        if (uniqueInstance == null) {
            uniqueInstance = new Oven(huawei);
        }

        return uniqueInstance;
    }

    public boolean switchOn() {
        if (turnedOn) {
            return false;
        } else {
            turnedOn = true;
            return true;
        }
    }

    public void setTimer(int timeInSeconds) {
        timer = new TimerThread(timeInSeconds);

    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void chooseProgram() {   //TODO
        System.out.println("You can choose between the following programs:");
        System.out.print("-ventilated (1)\n -grill (2)\n-reheat (3)\n");

        String decision = input.next();

        switch (decision) {
            case "1":
                program = Program.ventilated;
                time = 5;
                timer.setTimer(time);
                break;

            case "2":
                program = Program.grill;
                time = 6;
                timer.setTimer(time);
                break;

            case "3":
                program = Program.reheat;
                time = 7;
                timer.setTimer(time);
                break;

            default:
                System.out.println("Wrong input.");
                chooseProgram();
                break;
        }

    }

    public void start() {

        if (timer.getTime() == 0) {
            System.out.println("Set the timer first. \n");
            //execute();
            return;
        } else if (!turnedOn) {
            System.out.println("The oven is off. \n");
            //execute();
            return;
        } else if (temperature == 0) {
            System.out.println("There is no temperature set.");
            return;
        }
        cooking = true;
        Thread runner = new Thread(timer);
        runner.start();
        cooking = false;
    }

    public int getTimer() {
        return timer.getTime();
    }

    public void interruptProgram() {
        if (cooking && turnedOn == true) {
            cooking = false;
            program = null;
        }
    }

    public boolean switchOff() {
        turnedOn = false;
        return true;
    }

    /*
    public void execute() {
        if (!turnedOn) {
            System.out.println("The device is turned off.");
        } else {
            System.out.println("You can choose following functions: ");
            System.out.print("-set temperature (1) \n-get timer (2) \n-choose program (3) \n");
            System.out.print("-start (4) \n-exit (5) \n");

            String decision = input.next();

            switch (decision) {
                case "1":
                    System.out.print("Choose a temperature: ");
                    setTemperature(input.nextInt());
                    break;
                case "2":
                    int duration = getTimer();

                    if (duration > 0) {
                        System.out.println("The device needs " + duration + "s to complete the action.");
                    } else {
                        System.out.println("The timer is not set.");
                    }
                    break;

                case "3":
                    chooseProgram();
                    break;
                case "4":
                    start();
                    break;
                case "5":
                    System.out.println("Returning to main menu.");
                    huawei.mainPage();
                    break;
                default:
                    System.out.println("Wrong Input");
                    execute();
                    break;
            }
        }
    }

     */

    public String[] getOptions() {
        if(turnedOn){
            return optionsOn;
        }else{
            return optionsOff;
        }
    }

    public String[] execute(String decision) {
        switch (decision) {
            case "switch on":
                if (turnedOn) {
                    System.out.println("Device is already turned on.");
                    break;
                }
                System.out.println("Switched on device.");
                switchOn();
                break;

            case "switch off":
                if (!turnedOn) {
                    System.out.println("Device is already turned off.");
                    break;
                }
                System.out.println("Switched off device.");
                switchOff();
                break;

            case "set temperature":
                if (!turnedOn) {
                    System.out.println("The device is turned off.");
                    break;
                }
                System.out.print("Choose a temperature: ");
                setTemperature(input.nextInt());
                break;
            case "get timer":
                if (!turnedOn) {
                    System.out.println("The device is turned off.");
                    break;
                }
                int duration = getTimer();

                if (duration > 0) {
                    System.out.println("The device needs " + duration + "s to complete the action.");
                } else {
                    System.out.println("The timer is not set.");
                }
                break;

            case "choose program":
                if (!turnedOn) {
                    System.out.println("The device is turned off.");
                    break;
                }
                return new String[] {"ventilated", "grill", "reheat"};
                //chooseProgram();
                //break;
            case "start":
                if (!turnedOn) {
                    System.out.println("The device is turned off.");
                    break;
                }
                start();
                break;
            case "exit":
                System.out.println("Returning to main menu.");
                huawei.mainPage();
                break;
            case "ventilated":
                System.out.println("Set program to ventilated.");
                program = Program.ventilated;
                time = 5;
                timer.setTimer(time);
                break;
            case "grill":
                System.out.println("Set program to grill.");
                program = Program.grill;
                time = 6;
                timer.setTimer(time);
                break;
            case "reheat":
                System.out.println("Set program to reheat.");
                program = Program.reheat;
                time = 7;
                timer.setTimer(time);
                break;
            default:
                System.out.println("Wrong Input");
                //execute();
                break;
        }

        return null;
    }

    public String toString() {
        if (timer.isRunning()) {
            return "The oven is on and running.";
        } else {
            return "The oven is on.";
        }
    }
}
