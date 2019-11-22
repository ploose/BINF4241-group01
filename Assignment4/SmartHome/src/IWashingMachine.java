interface IWashingMachine extends Command{
    boolean switchOn();
    boolean switchOff();
    void setTemperature(int temperature);
    int getTimer();
    void chooseProgram();
    void start();
}