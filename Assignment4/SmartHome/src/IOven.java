public interface IOven extends Command{
    void setTimer(int time);
    void setTemperature(int temperature);
    void chooseProgram();
    void start();
    int getTimer();
    void interruptProgram();
}