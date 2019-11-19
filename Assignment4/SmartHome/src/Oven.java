
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

    public void setProgram(){   //TODO
        this.program = null;
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

    public void execute() {
        //TODO
    }
}
