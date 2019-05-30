package sd;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Producer implements Runnable {
  private static final Random rnd = new Random();
  private static final AtomicLong nextId = new AtomicLong();

  private final List<Consumer> consumers = new ArrayList<>();

  public Producer(List<Consumer> consumers) {
    this.consumers.addAll(consumers);
  }

  public void run() {
    while (true) {
      System.out.println(">>>>>>>> producing messages");
      for (int i = 0; i < 10 + rnd.nextInt(10); i++) {
        Message msg = new Message(rnd.nextInt(10), "message #" + nextId.getAndIncrement());
        consumers.forEach(c -> c.consume(msg));
      }

      try {
        Thread.sleep(30000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
