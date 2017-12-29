package stacks;

public class EmptyStack<X> implements Stack<X> {
	
	public EmptyStack() {};
	
	//Purpose: To return the top element in this Stack
	public X top() throws Exception {
		throw new Exception("Error Top: Cannot use top on an empty stack.");
	}

	//Purpose: To return this Stack without the Top element 
	public Stack<X> pop() throws Exception {
		throw new Exception("Error Pop: Cannot use pop on an empty stack.");
	}
	
	//Purpose: To check if this stack is empty
	public boolean emptyStack() {
		return true;
	}
	
	//Purpose: To push the value onto the Top of this stack.
	public Stack<X> push(X v) {
		return new NonEmptyStack<X>(v, new EmptyStack<X>());
	}
}
