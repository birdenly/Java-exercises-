import java.util.Locale;
import java.util.Scanner;

public class Base2To10 {

    // funçao para converter da base 2 pra base 10 passando o numero em string
    public static double base2To10(String numero){
        //inicializa
        double total = 0;
        int n = 0;
        //pega o numero em string e divide em char[] array = 1 1 0 1
        char[] array = numero.toCharArray();

        //percorre o tamanho do numero ate o ultimo
        for(int i = numero.length() -1; i > -1; i--){
            //total guarda o valor que é a multiplicação de um char do array vezes a potencia de 2 elevado a posição do numero atual.
            total = total + Character.getNumericValue(array[i]) * Math.pow(2,n);
            n = n + 1;
        }

        return total;
    }
    //main para imprimir
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double resul = base2To10(sc.nextLine());
        sc.close();

        System.out.println(resul);
        
    }
    
}

//Comportamento: para converter 1 1 0 1 pegamos um N que será o numero de digitos, nesse caso 4, e D será o numero naquela posição, sendo assim D x 2^N-1. 1 x 2^4-1 + 1 x 2^4-2 + 0 x 2^4-3 + 1 x 2^4-4 = 13
