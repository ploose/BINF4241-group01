interface IDishwasher extends Command {
    boolean switchOn();
    boolean switchOff();
    int getTimer();
    void chooseProgram();
    void start();
    void interruptProgram();
}