public interface IOven extends Command{
    boolean switchOn();
    boolean switchOff();
    void setTimer(int time);
    void setTemperature(int temperature);
    int getTimer();
    void chooseProgram();
    void start();
    void interruptProgram();
}