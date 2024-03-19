import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.PipedInputStream;
import java.util.Random;
class ProcessP4 extends Thread {
    private PipedInputStream inputStream;
    private PipedOutputStream outputStream;
    private int maxNumber = Integer.MIN_VALUE;

    public ProcessP4(PipedInputStream inputStream, PipedOutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int receivedNumber = inputStream.read();
                if (receivedNumber > maxNumber) {
                    maxNumber = receivedNumber;
                }
                System.out.println("Proces P4 otrzymał liczbę: " + receivedNumber);
                if (inputStream.available() == 0) {
                    outputStream.write(maxNumber);
                    System.out.println("Proces P4 przekazał największą liczbę: " + maxNumber);
                    outputStream.flush();
                    maxNumber = Integer.MIN_VALUE;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}