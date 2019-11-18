import java.sql.Time;

public class Oven {

    private boolean turnedOn;
    private int temperature;
    private Programs.Program program;
    private boolean cooking;
    TimerThread timer;

    public Oven(){
        program = null;
        temperature = 0;
        turnedOn = false;
        cooking = false;
        TimerThread timer = new TimerThread(0);
    }

    public void switchOn(){
        turnedOn = true;
    }
    public void setTimer(int timeInSeconds){

        timer = new TimerThread(timeInSeconds);
        timer.run(); // TODO: shouldn't the timer start with startCooking?
    }
    public void setTemperature(int temperature){
        this.temperature = temperature;
    }
    public void setProgram(Programs.Program program){
        this.program = program;
    }
    public void startCooking(){
        if (program != null && temperature != 0 && turnedOn == true){
            cooking = true;
        }

    }
    public int checkTimer(){
        return timer.getTime();
    }
    public void interruptProgram() {
        if (cooking == true && turnedOn == true) {
            cooking = false;
            program = null;
        }
    }
    public void switchOff(){
        turnedOn = false;
    }
}
