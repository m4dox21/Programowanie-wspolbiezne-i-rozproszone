import java.io.IOException;
import java.io.PipedOutputStream;
import java.util.Random;
class ProcessP3 extends Thread {
    private PipedOutputStream outputStream;
    private Random random;

    public ProcessP3(PipedOutputStream outputStream) {
        this.outputStream = outputStream;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                int randomNumber = random.nextInt(100); // Losowanie liczby całkowitej z zakresu [0, 100)
                outputStream.write(randomNumber);
                System.out.println("Proces P2 przekazał liczbę: " + randomNumber);
                outputStream.flush();
                sleep(random.nextInt(3000) + 1000); // Odczekanie losowej liczby sekund (od 1 do 3 sekund)
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}