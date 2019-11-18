public class TimerThread implements Runnable{
    private boolean running;
    private int time;

    TimerThread(int timeInSeconds){
        this.time = timeInSeconds;
    }

    int getTime(){
        return this.time;
    }

    boolean isRunning(){
        return running;
    }

    @Override
    public void run() {
        try {
            running = true;
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
