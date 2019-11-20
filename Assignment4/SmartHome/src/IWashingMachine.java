interface IWashingMachine extends Command{
    void setTemperature(int temperature);
    int getTimer();
    void chooseProgram();
    void start();
}