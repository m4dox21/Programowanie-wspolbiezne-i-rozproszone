public class ThreadClass extends Thread{
    private Licznik licznik;
    private boolean flag;
    private int zmiana;
    ThreadClass(Licznik licznik, boolean flag, int zmiana)
    {
        this.licznik = licznik;
        this.flag = flag;
        this.zmiana = zmiana;
    }

    @Override
    public void run()
    {
        if(flag)
        {
            for(int i=0;i<zmiana;i++)
            {
                licznik.inc();
            }
        }
        else
        {
            for(int i=0;i<zmiana;i++)
            {
                licznik.dec();
            }
        }
    }
}
