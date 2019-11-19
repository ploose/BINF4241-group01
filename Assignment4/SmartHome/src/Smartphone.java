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

    Smartphone() {
        getInstances();

        commands = new Command[5];
        fillSlots();

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

    private void run() {    //TODO
        System.out.println("CD Project Green Dev Team presents:");
        System.out.println("The smart home app");
        System.out.print("The app is starting. \n Please wait.");

        for (;;) {
            System.out.println("This is the main page. You have the following options: ");
            System.out.print("-Open cleaning robot page (1) \n -Open dishwasher page (2) \n -Open Microwave page (3)" +
                    " \n " + "-Open oven page (4) \n -Open washing machine page (5) \n -See all active smart devices " +
                    "(6)" + " \n -Close app (7)");

            String decision = input.next();

            switch (decision) {
                case "1":
                    openCleaningRobotPage();

                case "2":
                    openDishwasherPage();

                case "3":
                    openMicrowavePage();

                case "4":
                    openOvenPage();

                case "5":
                    openWashingMachinePage();

                case "6":
                    listAllTurnedOnDevices();

                case "7":
                    break;

                default:
                    System.out.println("Wrong input.");
            }
        }
    }

    private void openCleaningRobotPage() {
        System.out.println("You have the following options: ");
        System.out.print("-turn on (1) \n -turn off (2) \n -open functions (3) \n -return to main page (4) \n");

        String decision = input.next();

        switch (decision) {
            case "1":
                if (commands[0].switchOn()) {
                    turnedOn.add(cleaningRobot);
                }
                break;

            case "2":
                if (commands[0].switchOff()) {
                    turnedOn.remove(cleaningRobot);
                }
                break;

            case "3":
                commands[0].execute();
                break;

            case "4":
                System.out.println("Returning to main page.");
                break;

            default:
                System.out.println("Wrong Input.");
                openCleaningRobotPage();
                break;
        }
    }

    private void openDishwasherPage() {
        System.out.println("You have the following options: ");
        System.out.print("-turn on (1) \n -turn off (2) \n -open functions (3) \n -return to main page (4) \n");

        String decision = input.next();

        switch (decision) {
            case "1":
                if (commands[1].switchOn()) {
                    turnedOn.add(dishwasher);
                }
                break;

            case "2":
                if (commands[1].switchOff()) {
                    turnedOn.remove(dishwasher);
                }
                break;

            case "3":
                commands[1].execute();
                break;

            case "4":
                System.out.println("Returning to main page.");
                break;

            default:
                System.out.println("Wrong Input.");
                openDishwasherPage();
                break;
        }
    }

    private void openMicrowavePage() {
        System.out.println("You have the following options: ");
        System.out.print("-turn on (1) \n -turn off (2) \n -open functions (3) \n -return to main page (4) \n");

        String decision = input.next();

        switch (decision) {
            case "1":
                if (commands[2].switchOn()) {
                    turnedOn.add(microwave);
                }
                break;

            case "2":
                if (commands[2].switchOff()) {
                    turnedOn.remove(microwave);
                }
                break;

            case "3":
                commands[2].execute();
                break;

            case "4":
                System.out.println("Returning to main page.");
                break;

            default:
                System.out.println("Wrong Input.");
                openMicrowavePage();
                break;
        }
    }

    private void openOvenPage() {
        System.out.println("You have the following options: ");
        System.out.print("-turn on (1) \n -turn off (2) \n -open functions (3) \n -return to main page (4) \n");

        String decision = input.next();

        switch (decision) {
            case "1":
                if (commands[3].switchOn()) {
                    turnedOn.add(oven);
                }
                break;

            case "2":
                if (commands[3].switchOff()) {
                    turnedOn.remove(oven);
                }
                break;

            case "3":
                commands[3].execute();
                break;

            case "4":
                System.out.println("Returning to main page.");
                break;

            default:
                System.out.println("Wrong Input.");
                openOvenPage();
                break;
        }
    }

    private void openWashingMachinePage() {
        System.out.println("You have the following options: ");
        System.out.print("-turn on (1) \n -turn off (2) \n -open functions (3) \n -return to main page (4) \n");

        String decision = input.next();

        switch (decision) {
            case "1":
                if (commands[4].switchOn()) {
                    turnedOn.add(washingMachine);
                }
                break;

            case "2":
                if (commands[4].switchOff()) {
                    turnedOn.remove(washingMachine);
                }
                break;

            case "3":
                commands[4].execute();
                break;

            case "4":
                System.out.println("Returning to main page.");
                break;

            default:
                System.out.println("Wrong Input.");
                openWashingMachinePage();
                break;
        }
    }

    private void listAllTurnedOnDevices() {
        for (Command elem : turnedOn) {
            System.out.println(elem.toString());
        }
    }
}