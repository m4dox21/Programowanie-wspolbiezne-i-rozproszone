public class Licznik {
    private int x;
    Licznik()
    {
        this.x=0;
    }
    public synchronized void inc(){
        this.x = x + 1;
    }

    public synchronized void dec(){
        this.x = x - 1;
    }

    public int getX(){
        return x;
    }
}
