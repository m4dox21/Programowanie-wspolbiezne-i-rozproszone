public class Main {
    public static void main(String[] args) {
//        MyThread thread = new MyThread(1);
//        thread.start();
        int numThreads = 5;
        for (int i = 1; i <= numThreads; i++) {
            MyRunnable runnable = new MyRunnable(i);
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}