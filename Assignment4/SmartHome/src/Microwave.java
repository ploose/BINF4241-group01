import java.util.Scanner;

public class Microwave implements IMicrowave {
    private boolean turnedOn, baking;
    private int temperature;
    private int time = 0;
    private TimerThread timer;
    private Scanner input;

    private static Microwave uniqueInstance;

    private String[] optionsOn = {"start","set temperature","set timer","get timer","stop", "switch off"};
    private String[] optionsOff = {"switch on"};


    private Microwave(){
        temperature = 0;
        turnedOn = false;
        baking = false;
        timer = new TimerThread(0);
        input = new Scanner(System.in);
    }

    static Microwave getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Microwave();

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
    public void setTimer(int time){
        timer.setTimer(time);
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
                break;

            case "stop":
                interruptProgram();
                break;

            case "start":
                start();
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

}
