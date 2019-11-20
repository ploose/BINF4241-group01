import java.util.Scanner;

public class Microwave implements IMicrowave {
    private boolean turnedOn, baking;
    private int temperature;
    private TimerThread timer;
    Scanner input;
    private static Microwave uniqueInstance;

    private Microwave(){
        temperature = 0;
        turnedOn = false;
        baking = false;
        timer = new TimerThread(3);
        input = new Scanner(System.in);
    }

    static Microwave getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Microwave();
        }

        return uniqueInstance;
    }

    @Override
    public void switchOn(){
        turnedOn = true;
    }

    public void setTimer(int timeInSeconds){
        timer = new TimerThread(timeInSeconds);
        timer.run();
    }

    public void setTemperature(int temperature){
        this.temperature = temperature;
    }

    public void startBaking(){
        if (temperature != 0 && turnedOn){
            baking = true;
        }
    }
    public int checkTimer(){
        return timer.getTime();
    }

    public void interruptProgram() {
        if (baking && turnedOn) {
            baking = false;
        }
    }

    @Override
    public void switchOff(){
        turnedOn = false;
    }

    @Override
    public void execute() {
        if (!turnedOn) {
            System.out.println("The device is turned off.");
        }

        else {
            System.out.println("You can choose following functions: ");
            System.out.print("-set temperature (1) \n -get timer (2) \n -choose program (3) \n");
            System.out.print("-start (4) \n -exit (5) \n");

            String decision = input.next();

            switch (decision) {
                case "1":
                    System.out.print("Choose a temperature: ");
                    setTemperature(input.nextInt());

                case "2":
                    int duration = checkTimer();

                    if (duration > 0) {
                        System.out.println("The device needs " + duration + "s to complete the action.");
                    }

                case "3":
                    chooseProgram();

                case "4":
                    start();

                case "5":
                    System.out.println("Returning to main menu.");

                default:
                    System.out.println("Wrong Input");
                    execute();
            }
        }
    }

    }
}