public class Peterson {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Algorytm Petersona - " + MyThread.N + " wątki");

        MyThread[] newThread = new MyThread[MyThread.N];

        for (int i = 0; i < MyThread.N; i++) {
            newThread[i] = new MyThread("" + (i));
            newThread[i].start();
        }
    }
}
