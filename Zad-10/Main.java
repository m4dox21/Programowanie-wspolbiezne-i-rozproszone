import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbę elementów: ");
        int n = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        System.out.println("Podaj " + n + " liczb całkowitych:");
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        MasterClass master = new MasterClass(list);
        master.start();
    }
}