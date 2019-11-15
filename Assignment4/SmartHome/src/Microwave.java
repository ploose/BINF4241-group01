import java.sql.Time;

public class Microwave implements IMicrowave {

    private boolean turnedOn;
    private int temperature;
    private Programs.Program program;
    private boolean baking;
    TimerThread timer;

    public Microwave(){
        program = null;
        temperature = 0;
        turnedOn = false;
        baking = false;
        TimerThread timer = new TimerThread(0);
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
        if (temperature != 0 && turnedOn == true){
            baking = true;
        }

    }
    public int checkTimer(){
        return timer.getTime();
    }
    public void interruptProgram() {
        if (baking == true && turnedOn == true) {
            baking = false;
        }
    }
    public void switchOff(){
        turnedOn = false;
    }
}