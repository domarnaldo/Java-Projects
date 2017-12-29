package binarytreevisit;

// A Bintree is either a:
// - leafnode
// - interiornode

// A Bintree implements:
// 1. getRootval: --> X
// 2. isLeaf: --> boolean
// 3. getRightbt: --> bintree<X> or Exception
// 4. getLeftbt: --> bintree<X> or Exception
// 5. equals: bintree<X> --> boolean
// 6. inorderString: --> String
// 7. btMap: IBTree<X,Y> (Function) --> bintree<Y>
// 8. doubleTree: --> bintree<X>
// 9. visit: bintreeVisitor


public interface bintree<X> {
	
	//Purpose: To get the root value of the binary tree.
	public X getRootval(); 
	
	//Purpose: To check if the bintree is a leaf node.
	public Boolean isLeaf(); 
	
	//Purpose: To get the right binary tree.
	public bintree<X> getRightbt() throws Exception; 
	
	//Purpose: To get the left binary tree.
	public bintree<X> getLeftbt() throws Exception; 
	
	//Purpose: To check if a given bintree equals to this bintree.
	public Boolean equals(bintree<X> t); 
	
	//Purpose: To return the binary tree in order as a string.
	public String inorderString(); 
	
	//Purpose: To apply the map function given, on a binary tree.
	public <Y> bintree<Y> btMap(IBTreeF<X,Y> f); 
	
	//Purpose: To double a binary tree.
	public bintree<X> doubleTree(); 
	
	//Purpose: To visit this bintree of type X.
	public <R> R visit(bintreeVisitor<X,R> b); 
	
}
