interface IDishwasher extends Command {
    boolean switchOn();
    boolean switchOff();
    int getTimer();
    void start();
    void interruptProgram();
}