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
        cleaningRobot = CleaningRobot.getInstance(this);
        dishwasher = Dishwasher.getUniqueInstance(this);
        microwave = Microwave.getUniqueInstance(this);
        oven = Oven.getUniqueInstance(this);
        washingMachine = WashingMachine.getUniqueInstance(this);
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

        System.out.println("CD Project Green Dev Team presents:");
        System.out.println("The smart home app");
        System.out.println("The app is starting. \n" +
                "Please wait. \n");

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
                System.out.print(".");
            } catch (InterruptedException ignored) { }
        }

        System.out.print("\n");

        nokia3310.mainPage();

        System.out.println("System disconnecting.");
    }

    void mainPage() {
        for (;;) {
            System.out.println("This is the main page. You have the following options: ");
            System.out.print("-Open cleaning robot page (1) \n" +
                    "-Open dishwasher page (2) \n" +
                    "-Open microwave page (3) \n" +
                    "-Open oven page (4) \n" +
                    "-Open washing machine page (5) \n" +
                    "-See all active smart devices (6) \n" +
                    "-Close app (7) \n");

            String decision = this.input.next();

            switch (decision) {
                case "1":
                    this.openCleaningRobotPage();
                    break;

                case "2":
                    this.openDishwasherPage();
                    break;

                case "3":
                    this.openMicrowavePage();
                    break;

                case "4":
                    this.openOvenPage();
                    break;

                case "5":
                    this.openWashingMachinePage();
                    break;

                case "6":
                    this.listAllTurnedOnDevices();
                    break;

                case "7":
                    return;

                default:
                    System.out.println("Wrong input. \n");
                    break;
            }
        }
    }

    private void openCleaningRobotPage() {
        System.out.println("You have the following options: ");
        System.out.print("-turn on (1) \n" +
                "-turn off (2) \n" +
                "-open functions (3) \n" +
                "-return to main page (4) \n");

        String decision = input.next();

        switch (decision) {
            case "1":
                if (commands[0].switchOn()) {
                    add(commands[0]);
                }
                openCleaningRobotPage();
                break;

            case "2":
                if (commands[0].switchOff()) {
                    remove(commands[0]);
                }
                openCleaningRobotPage();
                break;

            case "3":
                commands[0].execute();
                openCleaningRobotPage();
                break;

            case "4":
                System.out.println("Returning to main page. \n");
                break;

            default:
                System.out.println("Wrong Input. \n");
                openCleaningRobotPage();
                break;
        }
    }

    private void openDishwasherPage() {
        System.out.println("You have the following options: ");
        System.out.print("-turn on (1) \n" +
                "-turn off (2) \n" +
                "-open functions (3) \n" +
                "-return to main page (4) \n");

        String decision = input.next();

        switch (decision) {
            case "1":
                if (commands[1].switchOn()) {
                    add(commands[1]);
                }
                openDishwasherPage();
                break;

            case "2":
                if (commands[1].switchOff()) {
                    remove(commands[1]);
                }
                openDishwasherPage();
                break;

            case "3":
                commands[1].execute();
                openDishwasherPage();
                break;

            case "4":
                System.out.println("Returning to main page. \n");
                break;

            default:
                System.out.println("Wrong Input. \n");
                openDishwasherPage();
                break;
        }
    }

    private void openMicrowavePage() {
        System.out.println("You have the following options: ");
        System.out.print("-turn on (1) \n" +
                "-turn off (2) \n" +
                "-open functions (3) \n" +
                "-return to main page (4) \n");

        String decision = input.next();

        switch (decision) {
            case "1":
                if (commands[2].switchOn()) {
                    add(commands[2]);
                }
                openMicrowavePage();
                break;

            case "2":
                if (commands[2].switchOff()) {
                    remove(commands[2]);
                }
                openMicrowavePage();
                break;

            case "3":
                commands[2].execute();
                openMicrowavePage();
                break;

            case "4":
                System.out.println("Returning to main page. \n");
                this.mainPage();
                break;

            default:
                System.out.println("Wrong Input. \n");
                openMicrowavePage();
                break;
        }
    }

    private void openOvenPage() {
        System.out.println("You have the following options: ");
        System.out.print("-turn on (1) \n" +
                "-turn off (2) \n" +
                "-open functions (3) \n" +
                "-return to main page (4) \n");

        String decision = input.next();

        switch (decision) {
            case "1":
                if (commands[3].switchOn()) {
                    add(commands[3]);
                }
                openOvenPage();
                break;

            case "2":
                if (commands[3].switchOff()) {
                    remove(commands[3]);
                }
                openOvenPage();
                break;

            case "3":
                commands[3].execute();
                openOvenPage();
                break;

            case "4":
                System.out.println("Returning to main page. \n");
                break;

            default:
                System.out.println("Wrong Input. \n");
                openOvenPage();
                break;
        }
    }

    private void openWashingMachinePage() {
        System.out.println("You have the following options: ");
        System.out.print("-turn on (1) \n" +
                "-turn off (2) \n" +
                "-open functions (3) \n" +
                "-return to main page (4) \n");

        String decision = input.next();

        switch (decision) {
            case "1":
                if (commands[4].switchOn()) {
                    add(commands[4]);
                }
                openWashingMachinePage();
                break;

            case "2":
                if (commands[4].switchOff()) {
                    remove(commands[4]);
                }
                openWashingMachinePage();
                break;

            case "3":
                commands[4].execute();
                openWashingMachinePage();
                break;

            case "4":
                System.out.println("Returning to main page. \n");
                break;

            default:
                System.out.println("Wrong Input. \n");
                openWashingMachinePage();
                break;
        }
    }

    private void listAllTurnedOnDevices() {
        for (Command elem : turnedOn) {
            System.out.println(elem.toString());
        }

        System.out.print("\n");
    }

    private void add(Command add) {
        if (!turnedOn.contains(add)) {
            turnedOn.add(add);
        }
    }

    private void remove(Command remove) {
        turnedOn.remove(remove);
    }
}