import java.util.Scanner;

class Dishwasher implements IDishwasher {
    private boolean turnedOn;
    private int time;
    private Program program;
    private TimerThread timer;
    private Scanner input;
    private static Dishwasher uniqueInstance;
    private String[] optionsOn = {"start", "switch off", "get timer", "choose program", "stop"};
    private String[] optionsOff = {"switch on"};

    private Dishwasher() {
        turnedOn = false;
        program = null;
        input = new Scanner(System.in);
        timer = new TimerThread(0);
    }

    static Dishwasher getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Dishwasher();
        }

        return uniqueInstance;
    }

    @Override
    public boolean switchOn() {
        if (turnedOn) {
            System.out.println("Dishwasher is already on.");
            return false;
        } else {
            turnedOn = true;
            return true;
        }
    }

    @Override
    public boolean switchOff() {
        if (!turnedOn) {
            System.out.println("Dishwasher is already off.");
            return false;
        } else if (timer.isRunning()) {
            System.out.println("Cannot turn the dishwasher off, it is still running.");
            return false;
        } else {
            turnedOn = false;
            return true;
        }
    }

    @Override
    public int getTimer() {
        if (timer.getTime() == 0) {
            System.out.println("The program has already terminated.");
            return time;
        } else if (!turnedOn) {
            System.out.println("The dishwasher is off.");
            return -1;
        } else if (program == null) {
            System.out.println("You first have to choose a program.");
            return -2;
        } else if (timer.isRunning()) {
            return timer.getTime();
        } else {
            return time;
        }
    }

    @Override
    public void start() {
        if (!turnedOn) {
            System.out.println("You first need to start the dishwasher. \n");
        } else if (program == null) {
            System.out.println("You first need to choose a program. \n");
        } else if (timer.isRunning()) {
            System.out.println("The dishwasher has already started. \n");
        } else {
            Thread runner = new Thread(timer);
            runner.start();


        }
    }

    @Override
    public void interruptProgram() {
        if (!turnedOn) {
            System.out.println("The dishwasher is not on. \n");
        } else if (!timer.isRunning()) {
            System.out.println("The dishwasher is not running. \n");
        } else {
            time = 0;
            timer = null;
            program = null;

            timer = new TimerThread(0);
        }
    }

    public String toString() {
        if (timer.isRunning()) {
            return "The dishwasher is on and running.";
        } else {
            return "The dishwasher is on.";
        }
    }

    @Override
    public String[] getOptions() {
        if (turnedOn) {
            return optionsOn;
        } else {
            return optionsOff;
        }
    }

    @Override
    public String[] execute(String decision) {
        switch (decision) {

            case "switch on":
                switchOn();
                break;

            case "switch off":
                switchOff();
                break;
            case "get timer":
                int duration = getTimer();

                if (duration > 0) {
                    System.out.println("The device needs " + duration + "s to complete the action. \n");
                }
                break;

            case "choose program":
                return new String[]{"glasses", "plates", "pans", "mixed"};
            //execute();
            case "glasses":
                System.out.println("Set program to ventilated.");
                program = Program.glasses;
                time = 5;
                timer.setTimer(time);
                break;
            case "plates":
                program = Program.plates;
                time = 6;
                timer.setTimer(time);
                break;
            case "pans":
                program = Program.pans;
                time = 7;
                timer.setTimer(time);
                break;
            case "mixed":
                program = Program.mixed;
                time = 8;
                timer.setTimer(time);
                break;

            case "start":
                start();
                break;

            case "stop":
                interruptProgram();
                break;


            default:
                System.out.println("Wrong Input \n");
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
}