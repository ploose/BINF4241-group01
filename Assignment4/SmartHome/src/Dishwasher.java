import java.util.Scanner;

class Dishwasher implements IDishwasher, Command {
    private boolean isOn, isRunning;
    private int time;
    private Programs.Program program;
    private TimerThread timer;

    private static Dishwasher uniqueInstance;

    private Dishwasher() {
        isOn = false;
        isRunning = false;
        program = null;
    }

    static Dishwasher getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Dishwasher();
        }

        return uniqueInstance;
    }

    public void switchOn() {
        if (isOn) {
            System.out.println("Dishwasher is already on.");
        } else {
            isOn = true;
        }
    }

    public void switchOff() {
        if (!isOn) {
            System.out.println("Dishwasher is already off.");
        } else if (isRunning) {
            System.out.println("Cannot turn the washing machine off, it is still running.");
        } else {
            isOn = false;
        }
    }

    public int getTimer() {
        if (!isOn) {
            System.out.println("The dishwasher is off.");
            return -1;
        }

        if (program == null) {
            System.out.println("You first have to choose a program.");
            return -2;
        }

        if (isRunning) {
            return timer.getTime();
        } else {
            return time;
        }
    }

    public void chooseProgram() {
        Scanner input = new Scanner(System.in);

        System.out.println("You can choose between the following programs:");
        System.out.print("-glasses \n -plates \n -pans \n -mixed");

        String decision = input.next();

        switch (decision) {
            case "glasses":
                program = Programs.Program.glasses;
                time = 5;

            case "plates":
                program = Programs.Program.plates;
                time = 6;

            case "pans":
                program = Programs.Program.pans;
                time = 7;

            case "mixed":
                program = Programs.Program.mixed;
                time = 8;

            default:
                System.out.println("Wrong input. \n");
                chooseProgram();
        }
    }

    public void start() {
        if (!isOn) {
            System.out.println("You first need to start the dishwasher.");
        }

        if (program == null) {
            System.out.println("You first need to choose a program");
        }

        if (isRunning) {
            System.out.println("The dishwasher has already started.");
        }

        isRunning = true;

        timer = new TimerThread(time);
        Thread runner = new Thread(timer);
        runner.start();

        for (;;) {
            if (!timer.isRunning()) {
                break;
            }
        }

        time = 0;
        timer = null;
        program = null;
        isRunning = false;
    }

    public void stop() {
        if (!isOn) {
            System.out.println("The dishwasher is not on.");
        }

        if (!isRunning) {
            System.out.println("The dishwasher is not running.");
        }

        time = 0;
        timer = null;
        program = null;
        isRunning = false;
    }

    public void execute() {

    }
}
