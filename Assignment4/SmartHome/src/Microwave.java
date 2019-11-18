public class Microwave implements IMicrowave {
    private boolean turnedOn, baking;
    private int temperature;
    private TimerThread timer;

    public Microwave(){
        temperature = 0;
        turnedOn = false;
        baking = false;
        timer = new TimerThread(3);
    }

    public void switchOn(){
        turnedOn = true;
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

    public void switchOff(){
        turnedOn = false;
    }
}