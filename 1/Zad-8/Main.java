public class Main {
    public static void main(String[] args) throws InterruptedException{
        Licznik licznik = new Licznik();
        ThreadClass t1 = new ThreadClass(licznik, true, 10000);
        ThreadClass t2 = new ThreadClass(licznik, false, 5000);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Stan licznika: "+licznik.getX());

    }
}