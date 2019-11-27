import java.util.ArrayList;
import java.util.Scanner;

public class Smartphone {
    private CleaningRobot cleaningRobot;
    private Dishwasher dishwasher;
    private Microwave microwave;
    private Oven oven;
    private WashingMachine washingMachine;
    private Command[] commands;
    private ArrayList<Command> turnedOn;
    private Scanner input;


    private Smartphone() {
        getInstances();

        commands = new Command[5];
        fillSlots();

        turnedOn = new ArrayList<>();
        input = new Scanner(System.in);
    }

    private void getInstances() {
        cleaningRobot = CleaningRobot.getInstance();
        dishwasher = Dishwasher.getUniqueInstance();
        microwave = Microwave.getUniqueInstance();
        oven = Oven.getUniqueInstance();
        washingMachine = WashingMachine.getUniqueInstance();
    }

    private void fillSlots() {
        commands[0] = cleaningRobot;
        commands[1] = dishwasher;
        commands[2] = microwave;
        commands[3] = oven;
        commands[4] = washingMachine;
    }

    public static void main(String[] args) {
        Smartphone nokia3310 = new Smartphone();

        System.out.println("CD Project Group 25 presents: The Smart Home App");
        System.out.print("The app is starting");

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
                System.out.print(".");
            } catch (InterruptedException ignored) { }
        }

        System.out.println("\n");

        nokia3310.mainPage();
    }

    private void mainPage() {
        for (;;) {
            System.out.println("This is the main page. You have the following options: ");
            System.out.print("- Open cleaning robot page (1) \n" +
                    "- Open dishwasher page (2) \n" +
                    "- Open microwave page (3) \n" +
                    "- Open oven page (4) \n" +
                    "- Open washing machine page (5) \n" +
                    "- See all active smart devices (6) \n" +
                    "- Close app (7) \n");

            String decision = this.input.next();

            switch (decision) {
                case "1":
                    devicePage(cleaningRobot.getOptions(), cleaningRobot, false);
                    break;

                case "2":
                    devicePage(dishwasher.getOptions(), dishwasher, false);
                    break;

                case "3":
                    devicePage(microwave.getOptions(), microwave, false);
                    break;

                case "4":
                    devicePage(oven.getOptions(), oven, false);
                    break;

                case "5":
                    devicePage(washingMachine.getOptions(), washingMachine, false);
                    break;

                case "6":
                    this.listAllTurnedOnDevices();
                    break;

                case "7":
                    System.out.println("System disconnecting.");
                    System.exit(0);

                default:
                    System.out.println("Wrong input. \n");
                    break;
            }
        }
    }

    private void devicePage(String[] options, Command device, boolean recursion){
        System.out.println("You have the following options: ");
        int i = 1;

        for(String option: options){
            System.out.println("- " + option + " ("+i++ + ")");
        }
        System.out.println("- return to previous page ("+i + ")");

        String decision = input.next();
        if(decision.equals(String.valueOf(i))){
            System.out.println("Returning to previous page. \n");
            return;
        }

        i = 1;
        String[] nestedMenu;

        for(String option: options){
            //System.out.println("Decision: "+ decision+", String.valueOf(i): "+ String.valueOf(i));
            if(decision.equals(String.valueOf(i++))){
                nestedMenu = device.execute(options[Integer.parseInt(decision)-1]);
                if(nestedMenu!=null){
                    // go into nested menu
                    devicePage(nestedMenu, device, true);
                }


            }

        }
        if(recursion){ // return from recursion if this was a nested menu
            return;
        }
        devicePage(device.getOptions(), device, false);
    }

    private void listAllTurnedOnDevices() {
        System.out.println("Active devices:");
        for (Command elem : commands) {
            if(elem.isActive()){
                System.out.println("- "+elem.toString());
            }
        }
        System.out.print("\n");
    }

}