public interface IMicrowave extends Command {
    void setTimer(int timeInSeconds);
    void setTemperature(int temperature);
    int getTimer();
    void start();
    void interruptProgram();
}