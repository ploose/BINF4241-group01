import java.util.Scanner;

public class Microwave implements IMicrowave {
    private boolean turnedOn, baking;
    private int temperature;
    private int time = 0;
    private TimerThread timer;
    private Scanner input;

    private Smartphone huawei;
    private static Microwave uniqueInstance;

    private String[] optionsOn = {"start","set temperature","set timer","get timer","stop", "switch off"};
    private String[] optionsOff = {"switch on"};


    private Microwave(Smartphone huawei){
        temperature = 0;
        turnedOn = false;
        baking = false;
        timer = new TimerThread(0);
        input = new Scanner(System.in);
        this.huawei = huawei;
    }

    static Microwave getUniqueInstance(Smartphone huawei) {
        if (uniqueInstance == null) {
            uniqueInstance = new Microwave(huawei);

        }

        return uniqueInstance;
    }

    @Override
    public boolean switchOn(){
        turnedOn = true;
        System.out.println("Switching on");
        return true;
    }

    @Override
    public void setTimer(int timeInSeconds){
        timer.setTimer(timeInSeconds);
    }

    @Override
    public void setTemperature(int temperature){
        this.temperature = temperature;
    }

    @Override
    public void start(){
        if (timer.getTime() == 0) {
            System.out.println("Set the timer first. \n");
            //execute();
            return;
        }
        else if (!turnedOn) {
            System.out.println("The microwave is off. \n");
            //execute();
            return;
        }

        else if (temperature == 0){
            System.out.println("There is no temperature set.");
            return;
        }
        baking = true;
        Thread runner = new Thread(timer);
        runner.start();
        baking = false;
    }

    @Override
    public int getTimer(){
        return timer.getTime();
    }

    @Override
    public void interruptProgram() {
        if (baking && turnedOn) {
            System.out.println("Program interrupted.");
            baking = false;
            time = 0;
            temperature = 0;
        }else{
            System.out.println("Microwave is not in operation.");
        }

    }

    @Override
    public boolean switchOff(){
        turnedOn = false;
        return true;
    }

    /*
    public void execute() {
        if (!turnedOn) {
            System.out.println("The device is turned off.");
        }

        else {
            System.out.println("You can choose following functions: ");
            System.out.print("-set temperature (1) \n-get timer (2) \n-set timer(3) \n-start(4) \n");
            System.out.print("-exit (5) \n");

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
                    }
                    else{
                        System.out.println("Timer not set!");
                    }
                    break;

                case "3":
                    System.out.print("Choose a time: ");
                    setTimer(input.nextInt());
                    execute();
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

    public String toString() {
        if (timer.isRunning()) {
            return "The microwave is on and running.";
        }

        else {
            return "The microwave is on.";
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
                    System.out.println("The device needs " + duration + "s to complete the action.");
                }
                else{
                    System.out.println("Timer not set!");
                }
                break;

            case "set timer":
                System.out.print("Choose a time: ");
                setTimer(input.nextInt());
                //execute();
                break;

            case "stop":
                start();
                break;


            default:
                System.out.println("Wrong Input");
                //execute();
                break;
        }
        return null;
    }

}
