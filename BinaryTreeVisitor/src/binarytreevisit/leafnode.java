package binarytreevisit;

public class leafnode<X> extends Abintree<X> { 
	
	//Purpose: To construct a new leafnode with root value v.
	public leafnode(X v) 
	{
		val = v;
	}
	
	//Purpose: To check if the bintree is a leaf node.
	public Boolean isLeaf() { 
		return(true);
	}
	
	//Purpose: To get the right binary tree.
	public bintree<X> getRightbt() throws Exception {
		throw new Exception("getRightbt: A leaf doesnot have a right subtree");}
	
	//Purpose: To get the left binary tree.
	public bintree<X> getLeftbt() throws Exception {
		throw new Exception("getLeftbt: A leaf doesnot have a left subtree");}
	
	//Purpose: To check if a given bintree t equals to this bintree.
	public Boolean equals(bintree<X> t) { 
		return (this.getRootval().equals(t.getRootval()));}
	
	//Purpose: To return the binary tree in order as a string.
	public String inorderString() {
		return (this.getRootval().toString());}
	
	//Purpose: To apply the map function given, on a binary tree.
	public <Y> bintree<Y> btMap(IBTreeF<X,Y> f) { 
		return (new leafnode<Y>(f.f(this.getRootval())));}
	
	//Purpose: To visit this bintree of type X.
	public <R> R visit(bintreeVisitor<X,R> b) {
		return (b.leafnode(this.val));}
	
}
