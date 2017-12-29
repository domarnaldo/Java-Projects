package binarytreevisit;

public interface bintreeVisitor<X,R> {
	
	//Purpose: Retrieves the information from the interiornode and returns a result based on the visitor.
	public R interiornode(X val, R l, R r);
	
	//Purpose: Retrieves the information from the leafnode and returns a result based on the visitor.
	public R leafnode(X v);
	
}
