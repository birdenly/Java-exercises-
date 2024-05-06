
import java.lang.Math;
import java.util.Queue;

public class Produtor extends MyQueue implements Runnable{

    private int thread;

    public Produtor(int thread, Queue<Double> blockingQueue){
        super(blockingQueue);
        this.thread = thread;
    }
    @Override
    public void run() { 
        
        double i = 0;
        while (i<qtd) {
            i++;
            BlockingQueue.offer(i);
            System.out.println("Elemento adicionado ao Produtor " + thread + " :    " + i);
            int max = 800;
            int min = 200;
            int range = max - min + 1;
            
            int rand = (int)(Math.random() * range) + min;

            try {
                Thread.sleep(rand);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
    
    }
}
