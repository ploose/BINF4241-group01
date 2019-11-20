import java.util.Scanner;

class Dishwasher implements IDishwasher, Command {
    private boolean isOn;
    private int time;
    private Program program;
    private TimerThread timer;
    private Scanner input;

    private static Dishwasher uniqueInstance;

    private Dishwasher() {
        isOn = false;
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
        if (isOn) {
            System.out.println("Dishwasher is already on.");
            return false;
        }

        else {
            isOn = true;
            return false;
        }
    }

    @Override
    public boolean switchOff() {
        if (!isOn) {
            System.out.println("Dishwasher is already off.");
            return false;
        }

        else if (timer.isRunning()) {
            System.out.println("Cannot turn the dishwasher off, it is still running.");
            return false;
        }

        else {
            isOn = false;
            return true;
        }
    }

    @Override
    public int getTimer() {
        if (time == 0) {
            System.out.println("The program has already terminated.");
            return time;
        }

        else if (!isOn) {
            System.out.println("The dishwasher is off.");
            return -1;
        }

        else if (program == null) {
            System.out.println("You first have to choose a program.");
            return -2;
        }

        else if (timer.isRunning()) {
            return timer.getTime();
        }

        else {
            return time;
        }
    }

    @Override
    public void chooseProgram() {
        System.out.println("You can choose between the following programs:");
        System.out.print("-glasses \n -plates \n -pans \n -mixed");

        String decision = input.next();

        switch (decision) {
            case "glasses\n":
                program = Program.glasses;
                time = 5;
                timer.setTimer(time);

            case "plates":
                program = Program.plates;
                time = 6;
                timer.setTimer(time);

            case "pans":
                program = Program.pans;
                time = 7;
                timer.setTimer(time);

            case "mixed":
                program = Program.mixed;
                time = 8;
                timer.setTimer(time);

            default:
                System.out.println("Wrong input. \n");
                chooseProgram();
        }
    }

    @Override
    public void start() {
        if (!isOn) {
            System.out.println("You first need to start the dishwasher.");
        }

        else if (program == null) {
            System.out.println("You first need to choose a program");
        }

        else if (timer.isRunning()) {
            System.out.println("The dishwasher has already started.");
        }

        else {
            Thread runner = new Thread(timer);
            runner.start();

            time = 0;
        }
    }

    @Override
    public void stop() {
        if (!isOn) {
            System.out.println("The dishwasher is not on.");
        }

        else if (!timer.isRunning()) {
            System.out.println("The dishwasher is not running.");
        }

        else {
            time = 0;
            timer = null;
            program = null;

            timer = new TimerThread(0);
        }
    }

    @Override
    public void execute() {
        if (!isOn) {
            System.out.println("The device is turned off.");
        }

        else {
            System.out.println("You can choose following functions: ");
            System.out.print("-get timer (1) \n -choose program (2) \n -start (3) \n");
            System.out.print("-stop (4) \n -exit (5)");

            String decision = input.next();

            switch (decision) {
                case "1":
                    int duration = getTimer();

                    if (duration > 0) {
                        System.out.println("The device needs " + duration + "s to complete the action.");
                    }

                    execute();

                case "2":
                    chooseProgram();
                    execute();

                case "3":
                    start();
                    execute();

                case "4":
                    stop();
                    execute();

                case "5":
                    System.out.println("Returning to main menu.");

                default:
                    System.out.println("Wrong Input");
                    execute();
            }
        }
    }
}