package JavaBootCampTest;

public class Intercalar {
    public static void main(String[] args) {
        String linha = "010101";
        System.out.println(linha);
        for (int i = 0; i <= 2; i++) {
            linha = linha.replace("0", "x").replace("1", "0").replace("x", "1");
            System.out.println(linha);
        }
    }
}
