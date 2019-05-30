package sd;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Consumer implements Runnable {
  private static final AtomicInteger nextId = new AtomicInteger();

  private final int id;
  private final PriorityBlockingQueue<Message> queue = new PriorityBlockingQueue<>();

  public Consumer() {
    this.id = nextId.getAndIncrement();
  }

  public void consume(Message message) {
    queue.add(message);
  }

  @Override
  public void run() {
    while (true) {
      try {
        Message msg = queue.poll(100, TimeUnit.MILLISECONDS);
        if (msg != null) {
          processMessage(msg);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void processMessage(Message message) throws InterruptedException {
    System.out.println(this + ": " + message);
    Thread.sleep(1000);
  }

  @Override
  public String toString() {
    return "Consumer #" + id;
  }
}
