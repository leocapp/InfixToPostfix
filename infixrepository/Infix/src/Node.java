import java.util.*;
public class Node {
	
	private char data;
    private Node nextNode;
    
    public Node(){
    }

    public Node(char data){
        this.data = data;
    }
    public Node(char data, Node next) {
    	this.data = data;
    	this.nextNode = next;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
    /*
     * This method takes a string of a postfix expression and evaluates it
     * */
    public static float evaluation(String post) {
    	//make an empty value stack
    	IntStackADT stack = new IntStackADT();
    	
    	//load all numbers into the stack from the postfix string given
    	for(int i = 0; i < post.length(); i++){
    		char ch = post.charAt(i);
    		//checking if the char is a number and then pushing it onto the value stack
    		if(Character.isDigit(ch)) {
    			stack.push(ch - '0');
    		}
    		//if an operator is encountered pop the last two numbers off the value stack and use them as operands
    		//for the operator found
    		else {
    			int operand1 = stack.pop();
    			int operand2 = stack.pop();
    			
    			//use the popped operands to do the next operation
    			switch(ch) {
    			case '+':
					stack.push(operand2 + operand1);
					break;
				case '-':
					stack.push(operand2 - operand1);
					break;
				case '*':
					stack.push(operand2 * operand1);
					break;
				case '/':
					stack.push(operand2 / operand1);
					break;
    			}	
    		}
    	}
    	//returns the last value which will be the answer
    	return stack.pop();
    }
    
    /*
     * Method to produce the priority level of each operator:
     * takes a char that will end up being a math operation and assigns it a
     * priority value
     * */
  	public static int getPriority(char ch) { 
          switch (ch) { 
          case '+': 
          case '-': 
          	//priority level 1
              return 1; 
         
          case '*': 
          case '/': 
          	//priority level 2
              return 2; 
         
          case '^': 
          	//priority level 3
              return 3; 
          } 
          return -1; //invalid
      }
  	
  	/*
	 * returns a the postfix statement as a queue, takes in a a string of
	 * the infix expression
	 * 
	 */
	private static QueueADT infixToPostfix(String infix) {
		QueueADT queue = new QueueADT();
		//loads the infix queue with the expression
		for(int i = 0; i <= infix.length()-1;i++) {
				char ch = infix.charAt(i);
				queue.enqueue(ch);
		}
		//create a result queue to hold postfix expression
		QueueADT resultQ = new QueueADT();
		//create operator stack to hold all operations
		StackADT stack = new StackADT();
		for(int i = 0; i <= infix.length()-1; i++) {
			char c = queue.dequeue();
			//if the scanned char is a digit add it to the result queue
			if(Character.isLetterOrDigit(c)) {
				resultQ.enqueue(c);
			}
			//if the scanned char is a ( then push it onto the operator stack
			else if(c == '(') {
				stack.push(c);
				
			}
			//if the scanned char is a ) then pop the last operator off the stack and 
			//place it on the queue as it takes precedence because it was in the ()
			else if(c == ')') {
				while(!stack.empty() && stack.onTop() != '(') {
					resultQ.enqueue(stack.pop());
					
					if(!stack.empty() && stack.onTop() != '(') {
						return null;//invalid statement
					}
					else {//kind of like a base case to get rid of () in the stack
						stack.pop();
					}
				}
			}
			//if the stack is not empty and the precedence of the current char is
			//less than or equal to the operator on top, enqueue the operator on top
			//then push the original char onto the stack
			else {
				while(!stack.empty() && getPriority(c) <= getPriority(stack.onTop())) {
					if(stack.onTop() == '(') 
						return null;//invalid statement
					resultQ.enqueue(stack.pop());//
				}
				stack.push(c);//original char, 
			}
		}
		//while the operator stack is not empty, enqueue everything in the operator stack
		while(!stack.empty()) {
			if(stack.onTop() == '(')
				return null;//invalid statement
			resultQ.enqueue(stack.pop());
		}
		//returns a the result queue
		return resultQ;
		
	}
    
    
/*
 * Main Method
 */
	public static void main(String[] args) {
		//StackADT stack = new StackADT();
		//QueueADT queue = new QueueADT();
		/*
		String infix = "1+2*4/5-7+3/6"; // = 3.9
		String infix3 = "1-2+5/5-7+3-8"; // = -12
		String infix4 = "1+2*4+5-7+3-1"; // = 9
		//String infix2 = "A+B*C/D-E+F/G";
		QueueADT postfix = infixToPostfix(infix4);
		StringBuilder str = new StringBuilder();
		for(int i = 0; i <= infix.length()-1; i++) {
			str.append(postfix.dequeue());
		}
		System.out.println("The postfix expression: " + str);
		String postfixExp = str.toString();
		System.out.println("The answer is: " + evaluation(postfixExp));
		*/
		Scanner k = new Scanner(System.in);
		System.out.print("Enter infix expression:");
		String infixString = k.nextLine();
		
		QueueADT postfixString = infixToPostfix(infixString);
		StringBuilder strString = new StringBuilder();
		for(int i = 0; i <= infixString.length()-1; i++) {
			strString.append(postfixString.dequeue());
		}
		System.out.println("The postfix expression: " + strString);
		String postfixExpString = strString.toString();
		System.out.println("The answer is: " + evaluation(postfixExpString));
		
	}
}










