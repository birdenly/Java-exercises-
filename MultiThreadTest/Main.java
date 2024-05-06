import java.util.Queue;
import java.util.LinkedList;
public class Main{

    public static void main(String[] args) {

        Queue<Double> BlockingQueue = new LinkedList<>(); 

            Produtor produtor = new Produtor(1,BlockingQueue);
            Thread myThread1 = new Thread(produtor);
            myThread1.start();

            Consumidor consumidor = new Consumidor(3,BlockingQueue);
            Thread myThread3 = new Thread(consumidor);
            myThread3.start();


            Produtor produtor2 = new Produtor(2,BlockingQueue);
            Thread myThread2 = new Thread(produtor2);
            myThread2.start();

            Consumidor consumidor2 = new Consumidor(4,BlockingQueue);
            Thread myThread4 = new Thread(consumidor2);
            myThread4.start();

        }
}