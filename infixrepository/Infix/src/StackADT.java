public class StackADT implements Stack{
	
	public int size;
    Node top;

	public StackADT() {
		top = null;
		size = 0;
	}
	
	/*
	 * Shows to node on the top of the stack without popping it off
	 */
	public void push(char data){
		Node newNode = new Node();
	     newNode.setData(data);
	     newNode.setNextNode(top);
	     top = newNode;
	     size++; 
    }
	
	/*
	 * Discards the last item placed in the stack
	 */
	public char pop() {
        /*if(empty()){
            throw new StackEmptyException("The Stack is empty");
        }*/
        Node node = new Node();
        node.setData(top.getData());//something is wrong here
        top = top.getNextNode();
        size--;
        return node.getData();//something may be wrong here
    }
	/*
	 * Shows to node on the top of the stack without popping it off
	 */
	public char onTop(){
        /*if(empty()){
            throw new StackEmptyException("The Stack is empty");
        }*/
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
