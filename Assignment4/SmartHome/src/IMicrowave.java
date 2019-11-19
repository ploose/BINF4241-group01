public interface IMicrowave extends Command {
    void setTimer(int timeInSeconds);
    void setTemperature(int temperature);
    void startBaking();
    int checkTimer();
    void interruptProgram();
}