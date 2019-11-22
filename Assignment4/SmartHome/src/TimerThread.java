public class TimerThread implements Runnable {
    private boolean running;
    private int time;
    private final Object lock = new Object();

    TimerThread(int timeInSeconds) {
        time = timeInSeconds;
    }

    int getTime() {
        synchronized (lock){
            return this.time;
        }
    }

    void setTimer(int time) {
        synchronized (lock){
            this.time = time;
        }
    }

    boolean isRunning() {
        synchronized (lock){
            return running;
        }
    }

    @Override
    public void run() {
        try {
            synchronized (lock){
                running = true;
            }


            while (time > 0) {
                Thread.sleep(1000);
                synchronized (lock){
                    --time;
                }
                //System.out.print(time);
                //System.out.println(running);
            }

            synchronized (lock){
                running = false;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
