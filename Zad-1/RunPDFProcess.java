import java.io.File;
import java.io.IOException;

public class RunPDFProcess {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\PC\\Desktop\\Zadania.pdf";

        try {
            File pdfFile = new File(filePath);
            if (!pdfFile.exists()) {
                System.err.println("Plik PDF nie istnieje.");
                return;
            }
            
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", filePath);
            processBuilder.directory(new File(System.getProperty("user.dir")));

            Process process = processBuilder.start();

            int exitCode = process.waitFor();

            System.out.println("Proces uruchamiania pliku zakończył się z kodem: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
