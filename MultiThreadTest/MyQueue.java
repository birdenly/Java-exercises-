import java.util.Queue;

public class MyQueue {

    public int qtd = 10; // mudar para oq quiser
    public Queue<Double> BlockingQueue;

    public MyQueue(Queue<Double> blockingQueue){
        this.BlockingQueue = blockingQueue;
    }
    public void setBlockingQueue(Queue<Double> blockingQueue) {
        this.BlockingQueue = blockingQueue;
    }

    public Queue<Double> getBlockingQueue() {
        return BlockingQueue;
    }
}
