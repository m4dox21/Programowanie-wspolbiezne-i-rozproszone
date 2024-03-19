public class InterleavingThreads2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                System.out.println("Thread 1");
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                System.out.println("Thread 2");
            }
        });

        thread1.start();
        thread2.start();
    }
}
