package stacks;

public class reverse {

	//revhelp: Stack<X> --> IList<X>
	//Purpose: to recursively create a new IList of X type elements from the given stack
	private static <X> IList<X> revhelp (Stack<X> s) {
		try {
			if (s.emptyStack()) {
				//if s is empty, return a new empty list
				//this occurs when reverseList is given an empty list, therefore the stack would be empty
				return new MTLIST<X>();
			}
			else {
				//recursively create a new list from the given stack by taking the "top" element
				//and "consing" the "rest" or the "pop" recursively
				return new NMTLIST<X>(s.top(), revhelp(s.pop()));
			}
		} catch (Exception e) {
			System.out.println("Revhelp error: " + e.getMessage());
			return null;
		}
	}
	
	//reverseList: IList<X> Stack<X> --> IList<X>
	//Purpose: to reverse the given IList using the given empty Stack<X>
	public static <X> IList<X> reverseList(IList<X> l, Stack<X> s) {
		if (l.isEmpty()) {
			//Occurs when the list is empty
			//The list can be empty if the given list is empty
			//Or when the structural recursion finishes
			return revhelp(s);
		}
		else {
			try {
				//Recursively push every element from the given IList "l" into the Stack "s"
				return reverseList(l.rest(), s.push(l.first()));
			} catch (Exception e) {
				System.out.println("Error reverseList function: " + e.getMessage());
				return null;
			}
		}
	}
	
	public static void main(String[] args) {
		
		//Visualizations of the reverse function working
		
		Stack<Integer> EMTSTACK = new EmptyStack<Integer>();
		IList<Integer> N = new MTLIST<Integer>();
		IList<Integer> N1 = N.cons(new Integer(5)).cons(new Integer(3)).cons(new Integer(6)).cons(new Integer(4));
		IList<Integer> R1 = reverseList(N1, EMTSTACK);
		
		Stack<String> EMTSTRINGSTACK = new EmptyStack<String>();
		IList<String> S = new MTLIST<String>();
		IList<String> S1 = S.cons(new String("dog")).cons(new String("cat")).cons(new String("elephant")).cons(new String("tiger"));
		IList<String> SREV1 = reverseList(S1, EMTSTRINGSTACK);
		
		try {
			
			System.out.println("List 1: " + N1.first() + " " + N1.rest().first() 
					+ " " + N1.rest().rest().first() + " " + N1.rest().rest().rest().first());
			System.out.println("List 1 Reverse: " + R1.first() + " " + R1.rest().first() 
					+ " " + R1.rest().rest().first() + " " + R1.rest().rest().rest().first());
			
			System.out.println("List 2: " + S1.first() + " " + S1.rest().first() 
					+ " " + S1.rest().rest().first() + " " + S1.rest().rest().rest().first());
			System.out.println("List 2 Reverse: " + SREV1.first() + " " + SREV1.rest().first() 
					+ " " + SREV1.rest().rest().first() + " " + SREV1.rest().rest().rest().first());
			
		} catch (Exception e) {
			System.out.println("Error Reverse Main Class: " + e.getMessage());
		}

	}

}
