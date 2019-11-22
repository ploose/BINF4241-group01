public interface IMicrowave extends Command {
    boolean switchOn();
    boolean switchOff();
    void setTimer(int time);
    void setTemperature(int temperature);
    int getTimer();
    void start();
    void interruptProgram();
}