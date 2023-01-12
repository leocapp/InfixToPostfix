public class QueueNode {
	
	private char data;
    private QueueNode nextNode;

    public QueueNode() {
    }
    public QueueNode(char data){
        this.data = data;
    }
    public QueueNode (char data, QueueNode nextNode) {
    	this.data = data;
    	this.nextNode = nextNode;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public QueueNode getNext() {
        return nextNode;
    }

    public void setNext(QueueNode nextNode) {
        this.nextNode = nextNode;
    }

}
