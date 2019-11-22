public interface ICleaningRobot extends Command{
    void setTimer(int time); // Set how much time is needed to for the cleaning job
    double getProgress(); // Elapsed Time in cleaning / Required Time for the full cleaning
    int getBattery(); // 0-100, percentage of battery charge remaining
    boolean start();
    void interruptProgram(); // Interrupt program, i.e. go back to base TODO: or endCleaning() ?
}
