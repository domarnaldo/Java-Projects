package dictionaries;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class HashingTest {
	HashComparator<String> scomp = new StringComparator();
	LPHash<String, String> ht = new LPHash<String, String>(11, scomp);
	DoubleHash<String, String> doubleHash = new DoubleHash<String, String>(11, scomp);
	
	@Test
	public void testHT() { 
		assertEquals(ht.size().intValue(), 0); 
		assertEquals(ht.isEmpty(), true);
		assertEquals(ht.findElement("Marco"), null);
		ht.insert("Marco", "Morazan"); 
		ht.insert("Nick", "Olson");
		ht.insert("Jean Luc", "Picard"); 
		ht.insert("Kathryn", "Janeway");
		assertEquals(ht.size().intValue(), 4);
		assertEquals(ht.isEmpty(), false);
		assertEquals(ht.findElement("Marco"), "Morazan");
		assertEquals(ht.findElement("Cathryn"), null);
		assertEquals(ht.findElement("Kathryn"), "Janeway");
		ht.delete("Kathryn");
		assertEquals(ht.findElement("Kathryn"), null);
		Iterator<String> klooper = ht.keys();
		Iterator<String> elooper = ht.elements();
		String res = "";
		while (klooper.hasNext()) { 
			res = res + " " + klooper.next() + " " + elooper.next(); 
		}
		assertEquals(res, " Jean Luc Picard Marco Morazan Nick Olson");
		
	}
	
	@Test
	public void testDoubleHash() { 
		assertEquals(doubleHash.size().intValue(), 0); 
		assertEquals(doubleHash.isEmpty(), true);
		assertEquals(doubleHash.findElement("Marco"), null);
		doubleHash.insert("Marco", "Morazan"); 
		doubleHash.insert("Nick", "Olson");
		doubleHash.insert("Jean Luc", "Picard"); 
		doubleHash.insert("Kathryn", "Janeway");
		assertEquals(doubleHash.size().intValue(), 4);
		assertEquals(doubleHash.isEmpty(), false);
		assertEquals(doubleHash.findElement("Marco"), "Morazan");
		assertEquals(doubleHash.findElement("Cathryn"), null);
		assertEquals(doubleHash.findElement("Kathryn"), "Janeway");
		doubleHash.delete("Kathryn");
		assertEquals(doubleHash.findElement("Kathryn"), null);
		Iterator<String> k2looper = doubleHash.keys();
		Iterator<String> e2looper = doubleHash.elements();
		String res = "";
		while (k2looper.hasNext()) { 
			res = res + " " + k2looper.next() + " " + e2looper.next(); 
		}
		assertEquals(res, " Jean Luc Picard Marco Morazan Nick Olson");
	}
	
	@Test
	public void testStringGenerator() {
		
		ArrayList<Item<String, String>> itemsArray = new ArrayList<Item<String, String>>();
		ArrayList<String> usedStrings = new ArrayList<String>();
		
		StringGenerator.generateItems(100, itemsArray, usedStrings);
		
		assertEquals(itemsArray.size(), 100);
		
	}
	
}
