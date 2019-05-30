package sd;

public class Message implements Comparable<Message> {
  private final int priority;
  private final String value;

  public Message(int priority, String value) {
    this.priority = priority;
    this.value = value;
  }

  public int getPriority() {
    return priority;
  }

  public String getValue() {
    return value;
  }

  @Override
  public int compareTo(Message msg) {
    return priority - msg.priority;
  }

  @Override
  public String toString() {
    return "Message{" +
      "priority=" + priority +
      ", value='" + value + '\'' +
      '}';
  }
}
