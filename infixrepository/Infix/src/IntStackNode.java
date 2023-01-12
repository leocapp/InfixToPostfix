public class IntStackNode {

	private int data;
    private IntStackNode nextNode;
    
    public IntStackNode(){
    }

    public IntStackNode(int data){
        this.data = data;
    }
    public IntStackNode(int data, IntStackNode next) {
    	this.data = data;
    	this.nextNode = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public IntStackNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(IntStackNode nextNode) {
        this.nextNode = nextNode;
    }
}
