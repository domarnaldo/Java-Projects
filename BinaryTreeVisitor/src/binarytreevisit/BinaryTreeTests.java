package binarytreevisit;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTreeTests {

	@Test
	public void test() {
		bintree<Integer> L = new leafnode<Integer>(2);
		bintree<Integer> R = new leafnode<Integer>(3);
		bintree<Integer> T = new interiornode<Integer>(1,L,R);
		bintree<Integer> L1 = new leafnode<Integer>(2);
		bintree<Integer> R1 = new leafnode<Integer>(3);
		bintree<Integer> T1 = new interiornode<Integer>(1,L1,R1);
		bintree<Integer> DL = new leafnode<Integer>(4);
		bintree<Integer> DR = new leafnode<Integer>(6);
		bintree<Integer> DT = new interiornode<Integer>(2,DL,DR);
		
		try { 
			assertEquals(L.getRootval().intValue(),2);
			assertEquals(T.getRootval().intValue(),1);
			assertEquals(T.getLeftbt(), L);
			assertEquals(T.getRightbt(), R);
			assertEquals(R.equals(R1), true);
			assertEquals(T.equals(T1), true);
			assertEquals(L1.inorderString(), "2");
			assertEquals(T.inorderString(), "2 1 3");
			assertEquals(R1.btMap(x -> 2 * x).equals(DR), true);
			assertEquals(T.btMap(x -> 2 * x).equals(DT), true); 
		} catch(Exception e) { 
			System.out.println("Error in test: " + e.getMessage()); 
		}
		
		//Doubling the tree
		bintree<Integer> L2 = new leafnode<Integer>(87);
		bintree<Integer> R2 = new leafnode<Integer>(201);
		bintree<Integer> T2 = new interiornode<Integer>(2, L2, R2);
		bintree<Integer> DTL = new interiornode<Integer>(2, L2, R2);
		bintree<Integer> DTR = new interiornode<Integer>(2, L2, R2);
		bintree<Integer> dTree = new interiornode<Integer>(2, DTL, DTR);
		
		try {
			assertEquals(T2.doubleTree().equals(dTree), true);
			assertEquals(L2.doubleTree().equals(new interiornode<Integer>(87, L2, L2)), true);
		} catch (Exception e) {
			System.out.println("Error in doubleTree Test: " + e.getMessage());
		}
		
		//Visitor Methods
		bintree<String> string1 = new leafnode<String>("cat");
		bintree<String> string2 = new leafnode<String>("dog");
		bintree<String> sTree1 = new interiornode<String>("hippo", string1, string2);
		bintreeVisitor<String,String> sv = new BinTreePostOrderVisit();
		assertEquals(sTree1.visit(sv), "cat dog hippo");
		assertEquals(string1.visit(sv), "cat");
		
		bintreeVisitor<Integer,Integer> iv = new BinTreeMaxInt();
		assertEquals(T2.visit(iv), new Integer(201));
		assertEquals(L2.visit(iv), new Integer(87));
		
		//Max with bigger tree
		bintree<Integer> L3 = new leafnode<Integer>(1000);
		bintree<Integer> R3 = new leafnode<Integer>(8888);
		bintree<Integer> T3 = new interiornode<Integer>(999, L3, R3);
		bintree<Integer> bigTree = new interiornode<Integer>(5, T2, T3);
		bintreeVisitor<Integer,Integer> iv2 = new BinTreeMaxInt();
		assertEquals(bigTree.visit(iv2), new Integer(8888));
		
	}

}
