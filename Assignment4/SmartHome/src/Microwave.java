public class Microwave implements IMicrowave {
    private boolean turnedOn, baking;
    private int temperature;
    private TimerThread timer;

    private static Microwave uniqueInstance;

    private Microwave(){
        temperature = 0;
        turnedOn = false;
        baking = false;
        timer = new TimerThread(3);
    }

    static Microwave getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Microwave();
        }

        return uniqueInstance;
    }

    @Override
    public boolean switchOn(){
        if (turnedOn) {
            System.out.println("Microwave is already on.");
            return false;
        }

        else {
            turnedOn = true;
            return true;
        }
    }

    @Override
    public boolean switchOff(){
        turnedOn = false;
        return true;
    }

    public void setTimer(int timeInSeconds){
        timer = new TimerThread(timeInSeconds);
        timer.run();
    }

    public void setTemperature(int temperature){
        this.temperature = temperature;
    }

    public void startBaking(){
        if (temperature != 0 && turnedOn){
            baking = true;
        }
    }
    public int checkTimer(){
        return timer.getTime();
    }

    public void interruptProgram() {
        if (baking && turnedOn) {
            baking = false;
        }
    }



    @Override
    public void execute() {
        //TODO
    }
}