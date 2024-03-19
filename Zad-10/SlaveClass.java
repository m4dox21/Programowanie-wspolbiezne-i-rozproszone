class SlaveClass extends Thread {
    private int x1;
    private int x2;
    private MasterClass master;

    public SlaveClass(int x1, int x2, MasterClass master) {
        this.x1 = x1;
        this.x2 = x2;
        this.master = master;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    @Override
    public void run() {
        int gcdResult = gcd(x1, x2);
        master.setValue(gcdResult);
    }
}