public class CustomSemafor {
    private int permits;
    private final Object lock = new Object();

    public CustomSemafor(int permits) {
        this.permits = permits;
    }


    public void acquire() throws InterruptedException {
        synchronized (lock) {
            while (permits==0) {
                lock.wait();
            }

            permits --;
        }
    }

    public void release() {
        synchronized (lock) {
            permits++;
            lock.notify();
        }
    }
}
