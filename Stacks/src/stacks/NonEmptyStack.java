package stacks;

public class NonEmptyStack<X> implements Stack<X> {
	
	private X top;
	private Stack<X> bottom;
	
	public NonEmptyStack(X t, Stack<X> b) {
		top = t;
		bottom = b;
	}
	
	//Purpose: To push the value onto the Top of this stack.
	public Stack<X> push(X v) {
		return new NonEmptyStack<X>(v, new NonEmptyStack<X>(top, bottom));
	}
	
	//Purpose: To return the top element in this Stack
	public X top() {
		return top;
	}
	
	//Purpose: To return this Stack without the Top element 
	public Stack<X> pop() {
		return bottom;
	}
	
	//Purpose: To check if this stack is empty
	public boolean emptyStack() {
		return false;
	}
}



