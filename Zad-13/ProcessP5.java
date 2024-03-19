import java.io.IOException;
import java.io.PipedInputStream;
class ProcessP5 extends Thread {
    private PipedInputStream inputStream;

    public ProcessP5(PipedInputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try {
            while (true) {
                StringBuilder sortedNumbers = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    int receivedNumber = inputStream.read();
                    sortedNumbers.append(receivedNumber);
                    sortedNumbers.append(", ");
                }
                sortedNumbers.delete(sortedNumbers.length() - 2, sortedNumbers.length());
                System.out.println("Posortowane liczby: " + sortedNumbers);
                inputStream.skip(inputStream.available());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}