public interface Command {
    // void execute();
    String[] getOptions();
    String[] execute(String decision);

    //boolean switchOn();
    //boolean switchOff();
}