public interface IDishwasher extends Command{
    int getTimer();
    void chooseProgram();
    void start();
    void stop();
}