import java.util.Locale;
import java.util.Scanner;

public class Primos {
    //first exercice that used args
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int qnt = sc.nextInt();
        sc.close();

        if (qnt < 1) {
            System.out.println("Você deve passar um parâmetro.");
            System.exit(0);
        }; //Converte para número a entrada
        var num = 2;

        var primo = 1;
            for(int i = 0; i < qnt;){
                for(int j= 2; j < num;j++){
                    if(num % j == 0){
                    primo = 0;
                    break;
                    }
                }
            if (primo != 0){
                System.out.println(num);
                i++;
            }
            primo = 1;
            num++;
            
        }
        

    }

}
