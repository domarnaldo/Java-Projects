package binarytreevisit;

public class BinTreeMaxInt implements bintreeVisitor<Integer,Integer>{

	//Purpose: Retrieves the information from visiting the interior node and returns the maximum of the interiornode.
	public Integer interiornode(Integer val, Integer l, Integer r) {
		return Math.max(Math.max(val, l), r);
	}

	//Purpose: Retrieves the information from the visiting leafnode and returns the maximum of the leafnode.
	public Integer leafnode(Integer v) {
		return v;
	}

}
