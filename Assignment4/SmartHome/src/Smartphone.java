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
    private boolean isRunning;

    private Smartphone() {
        isRunning = true;
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
        Smartphone huawei = new Smartphone();

        System.out.println("CD Project Green Dev Team presents:");
        System.out.println("The smart home app");
        System.out.println("The app is starting. \n" +
                "Please wait. \n");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {}

        while (huawei.isRunning) {
            System.out.println("This is the main page. You have the following options: ");
            System.out.print("-Open cleaning robot page (1) \n" +
                    "-Open dishwasher page (2) \n" +
                    "-Open Microwave page (3) \n" +
                    "-Open oven page (4) \n" +
                    "-Open washing machine page (5) \n" +
                    "-See all active smart devices (6) \n" +
                    "-Close app (7) \n");

            String decision = huawei.input.next();

            switch (decision) {
                case "1":
                    huawei.openCleaningRobotPage();
                    break;

                case "2":
                    huawei.openDishwasherPage();
                    break;

                case "3":
                    huawei.openMicrowavePage();
                    break;

                case "4":
                    huawei.openOvenPage();
                    break;

                case "5":
                    huawei.openWashingMachinePage();
                    break;

                case "6":
                    huawei.listAllTurnedOnDevices();
                    break;

                case "7":
                    huawei.isRunning = false;
                    break;

                default:
                    System.out.println("Wrong input. \n");
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