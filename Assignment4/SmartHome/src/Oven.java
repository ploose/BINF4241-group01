
public class Oven implements IOven{

    private boolean turnedOn;
    private int temperature;
    private Program program;
    private boolean cooking;
    private TimerThread timer;

    private static Oven uniqueInstance;

    private Oven(){
        program = null;
        temperature = 0;
        turnedOn = false;
        cooking = false;
        TimerThread timer = new TimerThread(0);
    }

    static Oven getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Oven();
        }

        return uniqueInstance;
    }

    public boolean switchOn(){
        turnedOn = true;
        return true;
    }

    public void setTimer(int timeInSeconds){
        timer = new TimerThread(timeInSeconds);
        timer.run(); // TODO: shouldn't the timer start with startCooking?
    }

    public void setTemperature(int temperature){
        this.temperature = temperature;
    }

    public void setProgram(){   //TODO
        this.program = null;
    }

    public void startCooking(){
        if (program != null && temperature != 0 && turnedOn){
            cooking = true;
        }
    }

    public int checkTimer(){
        return timer.getTime();
    }

    public void interruptProgram() {
        if (cooking && turnedOn) {
            cooking = false;
            program = null;
        }
    }

    public boolean switchOff(){
        turnedOn = false;
        return true;
    }

    public void execute() {
        //TODO
    }
}
