import java.util.Scanner;

public class Oven implements IOven {

    private boolean turnedOn;
    private int temperature;
    private Program program;
    private boolean cooking;
    private TimerThread timer;
    private Scanner input;
    int time;
    //private String[] options = {"switch on", "switch off", "set temperature", "get timer", "choose program", "start", "exit"};
    private String[] optionsOn = {"switch off", "set timer", "set temperature", "get timer", "choose program", "start", "stop"};
    private String[] optionsOff = {"switch on"};


    private static Oven uniqueInstance;

    private Oven() {
        program = null;
        temperature = 0;
        turnedOn = false;
        cooking = false;
        timer = new TimerThread(0);
        input = new Scanner(System.in);
    }

    static Oven getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Oven();
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

    public void setTimer(int time) {
        timer = new TimerThread(time);

    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void start() {

        if (timer.getTime() == 0) {
            System.out.println("Set the timer first. \n");
            return;
        } else if (!turnedOn) {
            System.out.println("The oven is off. \n");
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
            System.out.println("Interrupted oven.");
        }

        System.out.println("No oven operation to interrupt.");
    }

    public boolean switchOff() {
        turnedOn = false;
        return true;
    }

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

            case "set timer":
                if (!turnedOn) {
                    System.out.println("The device is turned off.");
                    break;
                }
                System.out.print("Choose a time: ");
                setTimer(input.nextInt());
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

            case "start":
                if (!turnedOn) {
                    System.out.println("The device is turned off.");
                    break;
                }
                start();
                break;

            case "stop":
                interruptProgram();
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
                break;
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
        if (timer.isRunning()) {
            return "The oven is on and running.";
        } else {
            return "The oven is on.";
        }
    }
}
