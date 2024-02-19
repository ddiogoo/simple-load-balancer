package channel;

import worker.Worker;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Channel {
    private final int numWorkers;
    private final int numTasks;
    private final BlockingQueue<Integer> channel;

    public Channel(int numWorkers, int numTasks) {
        this.numWorkers = numWorkers;
        this.numTasks = numTasks;
        channel = new ArrayBlockingQueue<>(numWorkers);
    }

    public void run() {
        for(int i = 0; i < numWorkers; i++) {
            new Thread(new Worker(i, channel)).start();
        }
        for(int i = 0; i < numTasks; i++) {
            try {
                channel.put(i);
            } catch(InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}
