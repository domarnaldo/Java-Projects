package binarytreevisit;

public class interiornode<X> extends Abintree<X> { 
	
	//Purpose: two bintrees of type X with l representing left one and r representing right one. 
	private bintree<X> l,r;
	
	//Purpose: To construct a interiornode with root value v of type X and two other bintrees of type X with l representing left one
	//and r representing right one.
	public interiornode(X v, bintree<X> left, bintree<X> right) {
		val = v;
		l = left;
		r = right;
	}
	
	//Purpose: To check if the bintree is a leaf node.
	public Boolean isLeaf() { 
		return(false);
	}

	//Purpose: To get the right binary tree.
	public bintree<X> getRightbt() throws Exception {
		return(this.r); 
	}
	
	//Purpose: To get the left binary tree.
	public bintree<X> getLeftbt() throws Exception { 
		return(this.l); 
	}
	
	//Purpose: To check if a given bintree equals to this bintree.
	public Boolean equals(bintree<X> t) { 
		try { 
			return(!t.isLeaf() && this.getRootval().equals(t.getRootval()) &&
					this.getLeftbt().equals(t.getLeftbt()) && this.getRightbt().equals(t.getRightbt())); 
		} catch(Exception e) { 
			System.out.println("Error equals in interior node: " + e.getMessage());
			return(false); 
		} 
	}
	
	//Purpose: To return the binary tree in order as a string.
	public String inorderString() { 
		try { 
			return(this.getLeftbt().inorderString()+ " " + this.getRootval().toString() + " " + 
					this.getRightbt().inorderString()); 
		} catch(Exception e) {
			System.out.println("Error inorderString in interiornode:" + e.getMessage());
			return(null);
		}
	}
	
	//Purpose: To apply the map function given, on a binary tree.
	public <Y> bintree<Y> btMap(IBTreeF<X,Y> f) { 
		try {
			return(new interiornode<Y>(f.f(this.getRootval()),this.getLeftbt().btMap(f), this.getRightbt().btMap(f)));
		} catch(Exception e) { 
			System.out.println("Error map in interiornode:" + e.getMessage());
			return(null);
		}
	} 
	
	//Purpose: To visit this bintree of type X.
	public <R> R visit(bintreeVisitor<X,R> b) {
		return (b.interiornode(this.val, this.l.visit(b), this.r.visit(b)));
	}
	
}