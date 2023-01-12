public class QueueADT {

	private int size;
    private QueueNode front, rear;
    
	public QueueADT() {
		size = 0;
        front = null;
        rear = null;
	}
	
	public void enqueue(char data){
		QueueNode newNode = new QueueNode ();
	     newNode.setData(data);
	     newNode.setNext(null);
	     if (this.empty()) 
	       front = newNode;
	     else
	       rear.setNext(newNode);
	     rear = newNode;
	     size++;
    }
	
	public char dequeue() {
        char result = front.getData();
        front = front.getNext();
        size--;
        if(empty()){
            rear = null;
        }
        return result;
    }
	
	public char front(){
        return front.getData();
    }
	
	public  boolean empty(){
        return size == 0;
    }

    public int size(){
        return size;
    } 
}
