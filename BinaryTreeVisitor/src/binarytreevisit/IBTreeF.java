package binarytreevisit;

// IBTreeF implements:
// 1. f: X --> Y

public interface IBTreeF<X,Y> {
	
	//Purpose: Returns type Y given the root value v of type X.
	public Y f(X v);

}
