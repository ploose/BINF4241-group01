public class Smartphone {
    private CleaningRobot cleaningRobot;
    private Dishwasher dishwasher;
    private Microwave microwave;
    private Oven oven;
    private WashingMachine washingMachine;
    private Command[] commands;

    Smartphone() {
        getInstances();

        commands = new Command[5];
        fillSlots();
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
}
