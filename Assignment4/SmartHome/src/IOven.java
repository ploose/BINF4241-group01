public interface IOven extends Command{
    void setTimer(int time);
    void setTemperature(int temperature);
    int getTimer();
    void chooseProgram();
    void start();
    void interruptProgram();
}