import java.util.Scanner;

class WashingMachine implements IWashingMachine {
    private boolean isOn;
    private int time, temperature;
    private Program program;
    private TimerThread timer;
    private Scanner input;

    private static WashingMachine uniqueInstance;

    private WashingMachine() {
        isOn = false;
        program = null;

        input = new Scanner(System.in);
        timer = new TimerThread(0);
    }

    static WashingMachine getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new WashingMachine();
        }

        return uniqueInstance;
    }

    @Override
    public boolean switchOn() {
        if (isOn) {
            System.out.println("Washing machine is already on. \n");
            return false;
        }

        else {
            isOn = true;
            return true;
        }
    }

    @Override
    public boolean switchOff() {
        if (!isOn) {
            System.out.println("Washing machine is already off. \n");
            return false;
        }

        else if (timer.isRunning()) {
            System.out.println("Cannot turn the washing machine off, it is still running. \n");
            return false;
        }

        else {
            isOn = false;
            return true;
        }
    }

    @Override
    public void setTemperature(int temperature) {
        if (timer.isRunning()) {
            System.out.println("The washing machine is still running, please wait until it's finished. \n");
        }

        else if (temperature > 20 && temperature < 100) {
            this.temperature = temperature;
        }

        else {
            System.out.println("This temperature is too hot or too low. Please choose a temperature between " +
                    "20 and 100 degrees. \n");
            this.temperature = -1;
        }
    }

    @Override
    public int getTimer() {
        if (time == 0) {
            System.out.println("The program has already terminated. \n");
            return time;
        }

        else if (!isOn) {
            System.out.println("The washing machine is off. \n");
            return -1;
        }

        if (program == null) {
            System.out.println("You first have to choose a program. \n");
            return -2;
        }

        if (timer.isRunning()) {
            return timer.getTime();
        }

        else {
            return time;
        }
    }

    @Override
    public void chooseProgram() {
        System.out.println("You can choose between the following programs:");
        System.out.print("-double rinse (1) \n" +
                "-intense (2) \n" +
                "-quick (3) \n" +
                "-spin (4) \n");

        String decision = input.next();

        switch (decision) {
            case "1":
                program = Program.rinse;
                time = 5;
                timer.setTimer(time);
                break;

            case "2":
                program = Program.intense;
                time = 6;
                timer.setTimer(time);
                break;

            case "3":
                program = Program.quick;
                time = 7;
                timer.setTimer(time);
                break;

            case "4":
                program = Program.spin;
                time = 8;
                timer.setTimer(time);
                break;

            default:
                System.out.println("Wrong input.");
                chooseProgram();
                break;
        }
    }

    @Override
    public void start() {
        if (!isOn) {
            System.out.println("You first need to start the washing machine. \n");
        }

        else if (program == null) {
            System.out.println("You first need to choose a program. \n");
        }

        else if (temperature == -1) {
            System.out.println("You need to enter a valid temperature. \n");
        }

        else if (timer.isRunning()) {
            System.out.println("The washing machine has already started. \n");
        }

        else {
            Thread runner = new Thread(timer);
            runner.start();

            time = 0;
        }
    }

    @Override
    public void execute() {
        if (!isOn) {
            System.out.println("The device is turned off. \n");
        }

        else {
            System.out.println("You can choose following functions: ");
            System.out.print("-set temperature (1) \n" +
                    "-get timer (2) \n" +
                    "-choose program (3) \n" +
                    "-start (4) \n" +
                    "-exit (5) \n");

            String decision = input.next();

            switch (decision) {
                case "1":
                    System.out.print("Choose a temperature: ");
                    setTemperature(input.nextInt());
                    break;

                case "2":
                    int duration = getTimer();

                    if (duration > 0) {
                        System.out.println("The device needs " + duration + "s to complete the action. \n");
                    }
                    break;

                case "3":
                    chooseProgram();
                    break;

                case "4":
                    start();
                    break;

                case "5":
                    System.out.println("Returning to washing machine page. \n");
                    break;

                default:
                    System.out.println("Wrong Input. \n");
                    execute();
            }
        }
    }

    public String toString() {
        if (timer.isRunning()) {
            return "The washing machine is on and running.";
        }

        else {
            return "The washing machine is on.";
        }
    }
}