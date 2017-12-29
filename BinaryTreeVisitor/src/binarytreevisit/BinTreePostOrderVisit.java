package binarytreevisit;

public class BinTreePostOrderVisit implements bintreeVisitor<String,String> {
	
	//Purpose: Retrieves the information from visiting the interior node and returns a String of the interiornode.
	public String interiornode(String v, String l, String r) { 
		return(l + " " + r + " " + v); 
	}
	
	//Purpose: Retrieves the information from the visiting leafnode and returns a String of the leafnode.
	public String leafnode(String V) {
		return (V);
	}
	
}
