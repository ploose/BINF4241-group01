public interface IOven extends Command{
    void switchOn();
    void setTimer();
    void setTemperature();
    void setProgram();
    void startCooking();
    void checkTimer();
    void interruptProgram();
    void switchOff();
}
