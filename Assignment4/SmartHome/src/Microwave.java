import java.util.Scanner;

public class Microwave implements IMicrowave {
    private boolean turnedOn, running;
    private int temperature;
    private TimerThread timer;
    private Scanner input;

    private static Microwave uniqueInstance;


    private Microwave(){
        temperature = 0;
        turnedOn = false;
        running = false;
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
            return;
        }
        else if (!turnedOn) {
            System.out.println("The microwave is off. \n");
            return;
        }

        else if (temperature == 0){
            System.out.println("There is no temperature set.");
            return;
        }
        running = true;
        Thread runner = new Thread(timer);
        runner.start();
    }

    @Override
    public int getTimer(){
        return timer.getTime();
    }

    @Override
    public void interruptProgram() {
        if (running && turnedOn) {
            System.out.println("Program interrupted.");
            running = false;
            timer = new TimerThread(0);
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
            if(running){
                return new String[]{"get timer", "stop"};
            }else if(temperature != 0 && timer.getTime() > 0){
                return new String[]{"start", "set timer", "set temperature", "get timer", "switch off"};
            }else{
                return new String[]{"set timer", "set temperature", "get timer", "switch off"};
            }
        }else{
            return new String[]{"switch on"};
        }
    }

    @Override
    public String[] execute(String decision) {
        if(timer.isRunning()){
            running = true;
        }else{
            running = false;
        }

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
                    System.out.println("The timer is not set or finished.");
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
