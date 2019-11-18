public class CleaningRobot implements ICleaningRobot, Runnable {
    private boolean turnedOn = false, isCleaning = false;
    private double requiredTime = 0, elapsedTime = 0;
    private int battery = 100;
    private final int chargeCycle = 100, dischargeCycle = 500;
    private final Object lock = new Object();

    public CleaningRobot() {
    }

    public void run() {
        while (true) {
            if (turnedOn) {
                if (battery == 100 && elapsedTime < requiredTime) {
                    synchronized (lock) {
                        isCleaning = true;
                    }
                } else if (elapsedTime >= requiredTime) {
                    synchronized (lock) {
                        isCleaning = false;
                    }
                }
                if (isCleaning && battery > 0) { // Discharging
                    try {
                        Thread.sleep(dischargeCycle);
                        synchronized (lock) {
                            if (battery > 0) {
                                elapsedTime += ((double) dischargeCycle / 1000);
                                battery--;
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else if (battery < 100) { // Charging
                    isCleaning = false;
                    try {
                        Thread.sleep(chargeCycle);
                        synchronized (lock) {
                            if (battery < 100) {
                                battery++;
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void switchOn() {
        if (requiredTime > 0 && battery == 100) {
            turnedOn = true;
        } else {
            System.out.println("Cleaning Robot has no set timer / is not fully charged!");
        }
    }

    @Override
    public void setTimer(int timeInSeconds) {
        if (!isCleaning) { // TODO: should it be possible to alter time while in base?
            this.requiredTime = timeInSeconds;
            this.elapsedTime = 0;
        } else {
            System.out.println("Can't set timer while cleaning!");
        }
    }

    @Override
    public double checkProgress() {
        synchronized (lock) {
            if (requiredTime == 0) {
                return 1;
            }
            if (turnedOn) {
                return elapsedTime / requiredTime;
            }
            return -1; // TODO: check turnedOn in phone?
        }
    }

    @Override
    public int checkBattery() {
        synchronized (lock) {
            if (turnedOn) {
                int tmp = battery;
                return tmp;
            }
            return -1; // TODO: check turnedOn in phone?
        }
    }

    @Override
    public void interruptProgram() {
        if (turnedOn) {
            synchronized (lock) {
                this.requiredTime = 0;
                this.elapsedTime = -0.5;
                this.isCleaning = false;
            }
        }
    }

    @Override
    public void switchOff() {
        turnedOn = false;
    }
}
