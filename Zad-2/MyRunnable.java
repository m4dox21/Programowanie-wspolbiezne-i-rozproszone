class MyRunnable implements Runnable {
    private int threadNumber;

    public MyRunnable(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    public void run() {
        System.out.println("Hello world! - Runnable Thread " + threadNumber);
    }
}