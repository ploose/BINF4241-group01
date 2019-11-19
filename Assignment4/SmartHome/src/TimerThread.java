public class TimerThread implements Runnable{
    private boolean running;
    private int time, timer;

    TimerThread(int timeInSeconds){
        timer = timeInSeconds;
    }

    int getTime(){
        return this.time;
    }

    void setTimer(int timer) {
        this.timer = timer;
    }

    boolean isRunning(){
        return running;
    }

    @Override
    public void run() {
        try {
            running = true;
            time = timer;

            while (time != 0) {
                Thread.sleep(1000);
                --time;
            }
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
