public interface ICleaningRobot extends Command{
    void switchOn(); // Switch off "Power-safer", all functions are available TODO: or start() ?
    void setTimer(int timeInSeconds); // Set how much time is needed to for the cleaning job
    double checkProgress(); // Elapsed Time in cleaning / Required Time for the full cleaning
    int checkBattery(); // 0-100, percentage of battery charge remaining
    void interruptProgram(); // Interrupt program, i.e. go back to base TODO: or endCleaning() ?
    void switchOff(); // Switch on "Power-safer", only switchOn() is available
}
