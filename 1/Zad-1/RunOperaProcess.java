import java.io.IOException;

public class RunOperaProcess {
    public static void main(String[] args) {
        String operaPath = "C:\\Program Files\\Opera\\opera.exe";

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(operaPath);

            Process process = processBuilder.start();

            int exitCode = process.waitFor();

            System.out.println("Proces przeglądarki Opera zakończył się z kodem: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
