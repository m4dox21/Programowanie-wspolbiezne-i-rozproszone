import java.util.concurrent.Callable;
class SumTask implements Callable<Double> {
    private final int start;
    private final int end;

    public SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Double call() {
        double sum = 0.0;
        for (int i = start; i <= end; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }
}