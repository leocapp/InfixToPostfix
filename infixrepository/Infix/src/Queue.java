
public interface Queue {
	   public void enqueue(int item);
	   public int dequeue();// throws QueueEmptyException;
	   public int size();
	   public boolean empty();
	   public boolean full();
	   public int front();//throws QueueEmptyException;

}
