import java.util.Scanner;

public class Oven implements IOven {
    enum Program {
        ventilated,
        grill,
        reheat
    }

    private boolean turnedOn;
    private int temperature;
    private Program program;
    private boolean running;
    private TimerThread timer;
    private Scanner input;


    private static Oven uniqueInstance;

    private Oven() {
        temperature = 0;
        turnedOn = false;
        running = false;
        timer = new TimerThread(0);
        input = new Scanner(System.in);
        program = null;
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
        running = true;
        Thread runner = new Thread(timer);
        runner.start();
    }

    public int getTimer() {
        return timer.getTime();
    }

    public void interruptProgram() {
        if (running && turnedOn == true) {
            System.out.println("Program interrupted.");
            running = false;
            timer = new TimerThread(0);
            temperature = 0;
            program = null;
        }

        System.out.println("No oven operation to interrupt.");
    }

    public boolean switchOff() {
        turnedOn = false;
        return true;
    }

    public String[] getOptions() {
        if (turnedOn) {
            if (running) {
                return new String[]{"get timer", "stop"};
            } else if (temperature != 0 && timer.getTime() > 0 && program != null) {
                return new String[]{"start", "set timer", "set temperature", "choose program", "get timer", "switch off"};
            } else {
                return new String[]{"set timer", "set temperature", "choose program", "get timer", "switch off"};
            }
        } else {
            return new String[]{"switch on"};
        }
    }

    public String[] execute(String decision) {
        if(timer.isRunning()){
            running = true;
        }else{
            running = false;
        }
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
                    System.out.println("The timer is not set or finished.");
                }
                break;

            case "choose program":
                if (!turnedOn) {
                    System.out.println("The device is turned off.");
                    break;
                }
                return new String[]{"ventilated", "grill", "reheat"};

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
                program = Program.ventilated;
                System.out.println("Set program to ventilated.");
                break;

            case "grill":
                program = Program.grill;
                System.out.println("Set program to grill.");
                break;

            case "reheat":
                program = Program.reheat;
                System.out.println("Set program to reheat.");
                break;

            default:
                System.out.println("Wrong Input");
                break;
        }

        return null;
    }

    @Override
    public boolean isActive() {
        if (turnedOn) {
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
