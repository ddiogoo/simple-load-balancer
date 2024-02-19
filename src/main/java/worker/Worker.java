package worker;

import java.util.concurrent.BlockingQueue;

public class Worker implements Runnable{
    private final int workerId;
    private final BlockingQueue<Integer> data;

    public Worker(int workerId, BlockingQueue<Integer> data) {
        this.workerId = workerId;
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while(true) {
                int x = data.take();
                System.out.printf("Worker %d received %d\n", workerId, x);
                Thread.sleep(1000);
            }
        } catch(InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
