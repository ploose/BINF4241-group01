import java.util.Scanner;

class WashingMachine implements IWashingMachine {
    private boolean turnedOn;
    private int time, temperature;
    private Program program;
    private TimerThread timer;
    private Scanner input;

    private static WashingMachine uniqueInstance;

    private String[] optionsOn = {"start","set temperature", "choose program","get timer", "switch off"};
    private String[] optionsOff = {"switch on"};

    private WashingMachine() {
        turnedOn = false;
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
        if (turnedOn) {
            System.out.println("Washing machine is already on. \n");
            return false;
        }

        else {
            turnedOn = true;
            return true;
        }
    }

    @Override
    public boolean switchOff() {
        if (!turnedOn) {
            System.out.println("Washing machine is already off. \n");
            return false;
        }

        else if (timer.isRunning()) {
            System.out.println("Cannot turn the washing machine off, it is still running. \n");
            return false;
        }

        else {
            turnedOn = false;
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
        if (timer.getTime() == 0) {
            System.out.println("The program has already terminated. \n");
            return time;
        }

        else if (!turnedOn) {
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
    public void start() {
        if (!turnedOn) {
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

    public String toString() {
        if (timer.isRunning()) {
            return "The washing machine is on and running.";
        }

        else {
            return "The washing machine is on.";
        }
    }

    @Override
    public String[] getOptions() {
        if(turnedOn){
            return optionsOn;
        }else{
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

            case "set temperature":
                System.out.print("Choose a temperature: ");
                setTemperature(input.nextInt());
                break;

            case "get timer":
                int duration = getTimer();

                if (duration > 0) {
                    System.out.println("The device needs " + duration + "s to complete the action. \n");
                }
                break;

            case "choose program":
                break;

            case "start":
                start();
                break;

            default:
                System.out.println("Wrong Input. \n");
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