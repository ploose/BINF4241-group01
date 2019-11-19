public interface IOven extends Command{
    void setTimer();
    void setTemperature();
    void setProgram();
    void startCooking();
    void checkTimer();
    void interruptProgram();
}