package sd;

import java.util.Arrays;
import java.util.List;

public class ProplemApp {

  public static void main(String[] args) {

    List<Consumer> consumers = Arrays.asList(new Consumer(), new Consumer(), new Consumer());
    consumers.forEach(c -> new Thread(c).start());

    Producer producer = new Producer(consumers);
    new Thread(producer).start();

  }
}
