package JavaBootCampTest;

import java.util.Scanner;

public class Triangulo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número natural N: ");
        int n = scanner.nextInt();
        scanner.close();

        int nTriangulo = calcularTriangular(n);
        System.out.println("O " + n + "-ésimo número triangular é: " + nTriangulo);
        imprimirTriangulo(n);
    }

    public static int calcularTriangular(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + calcularTriangular(n - 1); // ex: 5+4+3+2+1=15
        }
    }

    public static void imprimirTriangulo(int n) {
        if (n == 1) {
            System.out.print("*");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.print("*");
            }
            System.out.println();
            imprimirTriangulo(n - 1); // fazer a proxima linha até o 1
        }
    }
}
