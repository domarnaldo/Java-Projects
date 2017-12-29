package stacks;


//A Stack is either:
//1. empty
//2. non-empty

//A StackList is either:
//1. empty
//2. non-empty

//A Stack implements:
//1. top: --> X or error
//2. pop: -->  Stack<X> or error
//3. emptyStack:  --> boolean
//4. push: X --> Stack<X>


public interface Stack<X> {
	
	//Purpose: To return the top element in the Stack
	public X top() throws Exception; 
	
	//Purpose: To return a Stack without the Top element 
	public Stack<X> pop() throws Exception;
	
	//Purpose: To check if the stack is empty
	public boolean emptyStack(); 
	
	//Purpose: To push the value onto the Top of the stack.
	public Stack<X> push(X val);
}




