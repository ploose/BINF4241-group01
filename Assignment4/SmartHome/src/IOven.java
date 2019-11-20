public interface IOven extends Command{
    void setTimer(int time);
    void setTemperature(int temperature);
    void setProgram(Program program);
    void startCooking();
    int checkTimer();
    void interruptProgram();
}