package radix;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class RadixTests {

	@Test
	public void test() {
		IBucket<Integer> B = new Bucket<Integer>();
		B.add(0);
		B.add(1);
		B.add(2);
		B.add(3);
		Integer X[] = {0,0,0,0};
		
		assertEquals(B.getElem(2), new Integer(2));
		assertEquals(B.toArray(X, 0), 4);
		assertArrayEquals(X, new Integer[] {0,1,2,3});
		assertEquals(B.getSize(), 0);
	}
	
	@Test
	public void testBuckets() {
		Buckets b = new Buckets(9);
		b.getBucket(0).add(new Integer(10));
		
		Buckets b1 = new Buckets(9);
		b1.getBucket(0).add(new Integer(11));
		b1.getBucket(1).add(new Integer(15));
		b1.getBucket(8).add(new Integer(20));
		
		Integer X[] = new Integer[3];
		b1.dumpBuckets(X);
		
		assertArrayEquals(X, new Integer[] {11,15,20});
		assertEquals(b.getBucket(0).getElem(0), new Integer(10));
		
	}
	
	@Test
	public void testRadix() {
		Integer n1 = new Integer(1000);
		Integer[] x = {10, 190, 100, 9828, 12};
		
		assertEquals(RadixSort.getLength(n1), 4);
		assertEquals(RadixSort.getDigit(n1, 4), 1);
		assertEquals(RadixSort.getLargest(x, 0, x.length-1), 4);
		
		//Sort x
		RadixSort.sort(x);
		assertArrayEquals(x, new Integer[] {10,12,100,190,9828});
	}

}
