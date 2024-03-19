import java.util.List;

class MasterClass extends Thread {
    private List<Integer> list;

    public MasterClass(List<Integer> list) {
        this.list = list;
    }

    public synchronized void setValue(int i) {
        list.add(i);
    }

    @Override
    public void run() {
        while (list.size() > 1) {
            int x1 = list.remove(list.size() - 1);
            int x2 = list.remove(list.size() - 1);
            SlaveClass slave = new SlaveClass(x1, x2, this);
            slave.start();
            try {
                slave.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Największy wspólny dzielnik: " + list.get(0));
    }
}