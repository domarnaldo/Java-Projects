package stacks;

public class EmptyListStack<X> implements Stack<X> {
	
	public EmptyListStack() {}
	
	//Purpose: To return the top element in this Stack
	public X top() throws Exception {
		throw new Exception("Error Top: can't return first of list");
	}
	
	//Purpose: To return this Stack without the Top element 
	public Stack<X> pop() throws Exception {
		throw new Exception("Error Pop: can't return rest of the list.");
	}
	
	//Purpose: To check if this stack is empty
	public boolean emptyStack() {
		return true;
	}
	
	//Purpose: To push the value onto the Top of this stack.
	public Stack<X> push(X v) {
		return new NonEmptyListStack<X>((new NMTLIST<X>(v, new MTLIST<X>())));
		}
	}




