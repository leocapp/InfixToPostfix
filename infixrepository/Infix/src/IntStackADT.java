public class IntStackADT implements IntStack {

	public int size;
    IntStackNode top;

	public IntStackADT() {
		top = null;
		size = 0;
	}
	
	/*
	 * Shows to node on the top of the stack without popping it off
	 */
	public void push(int data){
		IntStackNode newNode = new IntStackNode();
	     newNode.setData(data);
	     newNode.setNextNode(top);
	     top = newNode;
	     size++; 
    }
	
	/*
	 * Discards the last item placed in the stack
	 */
	public int pop() {
        IntStackNode node = new IntStackNode();
        node.setData(top.getData());//something is wrong here
        top = top.getNextNode();
        size--;
        return node.getData();//something may be wrong here
    }
	/*
	 * Shows to node on the top of the stack without popping it off
	 */
	public int onTop(){
        return top.getData();
    }
	
	/*
	 * Returns the size of the list
	 */
	public int size(){
        return size;
    }
	
	/*
	 * Returns true if the list is empty 
	 */
    public boolean empty(){
        return (top == null);
    }
}
