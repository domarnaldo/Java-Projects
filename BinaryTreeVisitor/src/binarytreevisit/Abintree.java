package binarytreevisit;

public abstract class Abintree<X> implements bintree<X> {
	
	//Purpose: The root value v of type X of the leafnode and interiornode.
	protected X val;
	
	//Purpose: To get the root value of the binary tree.
	public X getRootval() {return val;}
	
	//Purpose: To double a binary tree.
	public bintree<X> doubleTree() {return (new interiornode<X>(this.val, this, this));}
	
}
