public interface IOven extends Command{
    void setTimer(int time);
    void setTemperature(int temperature);
    void setProgram();
    void startCooking();
    int checkTimer();
    void interruptProgram();
}