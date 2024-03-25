public class MyThread extends Thread {
    private Lock lock;

    public MyThread(String num, Lock lock){
        super(num);
        this.lock = lock;
    }

    static class ThreadID {
        private static volatile int nextID = 0;
        private static ThreadLocal<Integer> threadID = ThreadLocal.withInitial(() -> nextID++);

        public static int get() {
            return threadID.get();
        }
    }

    @Override
    public void run(){
        while(true) {
            //sekcja lokalna
            try {
                Thread.sleep((long) (2500 * Math.random()));
            } catch (InterruptedException e) {
            }
            // protokół wstępny
            lock.lock();

            //sekcja krytyczna
            System.out.println("Wątek "+ ThreadID.get() + " start SK");

            try{
                Thread.sleep((long)(1000 * Math.random()));
            }catch (InterruptedException e){
            }
            System.out.println("Wątek "+ ThreadID.get() + " stop SK");
            //protokół końcowy
            lock.unLock();
        }
    }
}