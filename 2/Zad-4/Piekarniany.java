public class Piekarniany {
    public static void main(String [] args) throws InterruptedException {
        final int N = 5;
        Lock blokada = new Piekarnia(N);
        Thread watki[] = new MyThread[N];

        for(int i=0; i<N; i++)
        {
            watki[i] = new MyThread(Integer.toString(i), blokada);

            watki[i].start();
        }
    }
}