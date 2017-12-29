package stacks;

public class NonEmptyListStack<X> implements Stack<X> {
	
	private IList<X> listStack;
	
	public NonEmptyListStack(IList<X> l) {
		
		listStack = l;		
	}
	
	//Purpose: To return the top element in this Stack
	public X top() throws Exception {
		try {
			return listStack.first();
		} catch(Exception e) {
			System.out.println("Error ListStack top: " + e.getMessage());
			return null;
		}
	}
	
	//Purpose: To return this Stack without the Top element 
	public Stack<X> pop() throws Exception {
		try {
			if(listStack.rest().isEmpty()) {
				return new EmptyListStack<X>();
			}
			else {
				return new NonEmptyListStack<X>(listStack.rest());
			}
		} catch(Exception e) {
			System.out.println("Error ListStack pop: " + e.getMessage());
			return null;
		}
	}
	
	//Purpose: To check if this stack is empty
	public boolean emptyStack() {
		return false;		
	}
	
	//Purpose: To push the value onto the Top of this stack.
	public Stack<X> push(X v) {
		return new NonEmptyListStack<X>(listStack.cons(v));
	}
}
