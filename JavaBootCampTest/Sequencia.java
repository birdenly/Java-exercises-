package JavaBootCampTest;

import java.util.Scanner;

public class Sequencia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número delimitador: ");
        int limite = scanner.nextInt();

        for (int i = 2; i <= limite; i += 2) {
            int resul = (int) Math.pow(i * i, 2);
            System.out.print(resul + ", " + (i - 2) + ", ");
        }

        scanner.close();
    }
}
