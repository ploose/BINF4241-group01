import java.util.Scanner;

public class Oven implements IOven{

    private boolean turnedOn;
    private int temperature;
    private Program program;
    private boolean cooking;
    private TimerThread timer;
    private Scanner input;

    private static Oven uniqueInstance;

    private Oven(){
        program = null;
        temperature = 0;
        turnedOn = false;
        cooking = false;
        TimerThread timer = new TimerThread(0);
        input = new Scanner(System.in);
    }

    static Oven getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Oven();
        }

        return uniqueInstance;
    }

    public void switchOn(){
        turnedOn = true;
    }

    public void setTimer(int timeInSeconds){
        timer = new TimerThread(timeInSeconds);
        timer.run(); // TODO: shouldn't the timer start with startCooking?
    }

    public void setTemperature(int temperature){
        this.temperature = temperature;
    }

    public void setProgram(Program program){   //TODO
        this.program = null;
    }

    public void startCooking(){
        if (program != null && temperature != 0 && turnedOn){
            cooking = true;
        }
    }

    public int checkTimer(){
        return timer.getTime();
    }

    public void interruptProgram() {
        if (cooking && turnedOn) {
            cooking = false;
            program = null;
        }
    }

    public void switchOff(){
        turnedOn = false;
    }

    public void execute() {
        if (!turnedOn) {
            System.out.println("The device is turned off.");
        }

        else {
            System.out.println("You can choose following functions: ");
            System.out.print("-set temperature (1) \n -get timer (2) \n -start (3) \n");
            System.out.print("-exit (4) \n -exit (5) \n");

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
                    startCooking();

                case "4":
                    System.out.println("Returning to main menu.");

                default:
                    System.out.println("Wrong Input");
                    execute();
            }
        }
        //TODO
    }
}
