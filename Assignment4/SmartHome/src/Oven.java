import java.util.Scanner;

public class Oven implements IOven{

    private boolean turnedOn;
    private int temperature;
    private Program program;
    private boolean cooking;
    private TimerThread timer;
    private Scanner input;
    int time;

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

    public boolean switchOn(){
        if (turnedOn) {
            return false;
        }

        else {
            turnedOn = true;
            return true;
        }
    }

    public void setTimer(int timeInSeconds){
        timer = new TimerThread(timeInSeconds);
        timer.run(); // TODO: shouldn't the timer start with startCooking?
    }

    public void setTemperature(int temperature){
        this.temperature = temperature;
    }

    public void setProgram(){   //TODO
        System.out.println("You can choose between the following programs:");
        System.out.print("-double rinse \n -intense \n -quick \n -spin");

        String decision = input.next();

        switch (decision) {
            case "ventilated":
                program = Program.ventilated;
                time = 5;
                timer.setTimer(time);

            case "grill":
                program = Program.grill;
                time = 6;
                timer.setTimer(time);

            case "reheat":
                program = Program.reheat;
                time = 7;
                timer.setTimer(time);

            default:
                System.out.println("Wrong input.");
                setProgram();
        }

    }

    public void startCooking(){
        if (program != null && temperature != 0 && turnedOn == true){
            cooking = true;
        }
    }

    public int checkTimer(){
        return timer.getTime();
    }

    public void interruptProgram() {
        if (cooking && turnedOn == true) {
            cooking = false;
            program = null;
        }
    }

    public boolean switchOff(){
        turnedOn = false;
        return true;
    }

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
                    setProgram();

                case "4":
                    startCooking();

                case "5":
                    System.out.println("Returning to main menu.");

                default:
                    System.out.println("Wrong Input");
                    execute();
            }
        }
    }

    public String toString() {
        if (timer.isRunning()) {
            return "The oven is on and running.";
        }

        else {
            return "The oven is on.";
        }
    }
}
