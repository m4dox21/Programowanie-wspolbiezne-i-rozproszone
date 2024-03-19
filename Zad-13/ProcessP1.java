import java.io.IOException;
import java.io.PipedOutputStream;
import java.util.Random;
class ProcessP1 extends Thread {
    private PipedOutputStream outputStream;
    private Random random;

    public ProcessP1(PipedOutputStream outputStream) {
        this.outputStream = outputStream;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                int randomNumber = random.nextInt(100);
                outputStream.write(randomNumber);
                System.out.println("Proces P1 przekazał liczbę: " + randomNumber);
                outputStream.flush();
                sleep(random.nextInt(3000) + 1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}