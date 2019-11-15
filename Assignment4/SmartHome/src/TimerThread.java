import java.sql.Time;
import java.util.*;

public class TimerThread implements Runnable{

    private boolean running;
    private int time;

    public TimerThread(int timeInSeconds){
        this.time = timeInSeconds;
    }

    public int getTime(){
        int tmp = this.time;
        return tmp;
    }

    public boolean isRunning(){return running;}


    @Override
    public void run() {
        try {
            running = true;
            while (time != 0){
                Thread.sleep(1000);
                time -= 1;
            }
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
