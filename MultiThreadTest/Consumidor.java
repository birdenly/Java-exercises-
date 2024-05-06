import java.util.Queue;
public class Consumidor extends MyQueue implements Runnable{

    private int thread;

    public Consumidor(int thread, Queue<Double> blockingQueue){
        super(blockingQueue);
        this.thread = thread;
    }
    @Override
    public void run() {
        int i = 0;
        while (i < qtd) {
            i++;
            System.out.println("Elemento dobrado no Consumidor "+ thread +":    " + BlockingQueue.poll() * 2);

            try {
                Thread.sleep(1000); //pior caso de demora
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
