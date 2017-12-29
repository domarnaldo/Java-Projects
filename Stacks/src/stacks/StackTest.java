package stacks;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest {

	@Test
	public void test() {
		
		//Integers Variables//
		MTLIST tester = new MTLIST();
		NMTLIST tester1 = new NMTLIST(new Integer (3), new NMTLIST(new Integer (6), tester));
		Stack<Integer> a = new EmptyStack<Integer>();
		Stack<Integer> b = new NonEmptyStack<Integer>(new Integer (5), new NonEmptyStack<Integer>(new Integer (6), a));
		Stack<Integer> a1 = new EmptyListStack<Integer>();
		Stack<Integer> h = new NonEmptyListStack(tester1);
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Strings Variables//
		MTLIST tester3 = new MTLIST();
		NMTLIST tester4 = new NMTLIST(new String ("Marco"), new NMTLIST(new String ("Shamil"), tester3));
		Stack<String> s = new EmptyStack<String>();
		Stack<String> s1 = new NonEmptyStack<String> (new String ("Alex"), s);
		Stack<String> s2 = new NonEmptyStack<String>(new String("Jonathan"), new NonEmptyStack<String>( new String ("Dom"),s1));
		Stack<String> j = new EmptyListStack<String>();
		Stack<String> j1 = new NonEmptyListStack<String>(tester4);
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				                              
		                                           ////////////////////
		                                           // INTEGERS TESTS //
		                                           ////////////////////
		
		//Tests For Top Method//
		////////////////////////
		
		//Test for NonEmptyListStack
		try {		
			assertEquals(h.top(), new Integer (3));
			} catch (Exception e) {
				System.out.println("NonEmptyListStack Test " +e.getMessage());
			}
		
		//Test for NonEmptyStack
		try {
			assertEquals(b.top(),new Integer (5));
		} catch (Exception e) {
			System.out.println("NonEmptyStack Test " +e.getMessage());
		}
		
		//Test For EmptyStack 
		try {
			System.out.println(a.top());
			}
			catch (Exception e)   {
				System.out.println("EmptyStack Test " +e.getMessage());
			}
		
		//Test For EmptyListStack
		try {
			System.out.println(a1.top());
			}
			catch (Exception e)   {
				System.out.println("EmptyListStack Test " +e.getMessage());
			}
		
				
		//Tests for pop method//
		////////////////////////
		
		//Test For NonEmptyListStack
		try {		
			assertEquals(h.pop().top(), new Integer (6));
			} catch (Exception e) {
				System.out.println("NonEmptyListStack Test " +e.getMessage());
			}
		
		//Test For NonEmptyStack
		try {
			assertEquals(b.pop().top(),new Integer (6));
		} catch (Exception e) {
			System.out.println("NonEmptyStack Test " +e.getMessage());
		}
		
		//Test For EmptyStack
		try {
			System.out.println(a.pop());
		}
		catch (Exception e)   {
			System.out.println("EmptyStack Test " +e.getMessage());
		}
		
		//Test For EmptyListStack
		try {
			System.out.println(a1.pop());
		}
		catch (Exception e)   {
			System.out.println("EmptyListStack Test " +e.getMessage());
		}
		
		
		//Tests For Empty Stack Method//
		////////////////////////////////
		
		//Test For EmptyStack
		assertEquals(a.emptyStack(), true);
			
		//Test For NonEmptyStack
		assertEquals(b.emptyStack(), false);
				
		//Test For EmptyListStack
	    assertEquals(a1.emptyStack(), true);
		
		//Test For NonEmptyListStack
		assertEquals(h.emptyStack(), false);
		
		
		//Tests For Push Method//
		/////////////////////////
		
		//Test For EmptyStack
		try {		
			assertEquals(a.push(1).top(), new Integer (1));
			} catch (Exception e) {
				System.out.println("EmptyStack Test " +e.getMessage());
			}
			
		//Test For NonEmptyStack
		try {		
			assertEquals(b.push(1).top(), new Integer (1));
			} catch (Exception e) {
				System.out.println("NonEmptyStack Test " +e.getMessage());
			}
		
		try {		
			assertEquals(b.push(1).push(2).top(), new Integer (2));
			} catch (Exception e) {
				System.out.println("NonEmptyStack Test " +e.getMessage());
			}	
		
		//Test For EmptyListStack
		try {
			assertEquals(a1.push( new Integer (2)).top(), new Integer (2));
		} catch (Exception e) {
			System.out.println("EmptyListStack Test " +e.getMessage());
		}
	
		//Test For NonEmptyListStack
		try {
			assertEquals(h.push(new Integer (3)).top(), new Integer (3));
		}  catch (Exception e) {
			System.out.println("NonEmptyListStack Test " +e.getMessage());
		}
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		                                            /////////////////
													//STRINGS TESTS//
		                                            /////////////////
		
		//Tests For Top Method//
		////////////////////////
		
		//Test For EmptyStack		
		try {		
			System.out.println(s.top());
			} catch (Exception e) {
				System.out.println("EmptyStack Test " +e.getMessage());
			}
		
		//Test For NonEmptyStack
		try {		
			assertEquals(s2.top(), new String ("Jonathan"));
			} catch (Exception e) {
				System.out.println("NonEmptyStack Test" +e.getMessage());
			}
		
		//Test For EmptyListStack
		try {
			System.out.println(j.top());
		} catch (Exception e) {
				System.out.println("EmptyListStack Test " +e.getMessage());
			}
		
		//Test For NonEmptyListStack
		try {
			assertEquals(j1.top(), new String ("Marco"));
		} catch (Exception e) {
			System.out.println("NonEmptyListStack Test " +e.getMessage());
		}
		
		
		//Tests For Pop Method//
		////////////////////////
		
		//Test For EmptyStack
		try {
			System.out.println(s.pop());
		}  catch (Exception e) {
			System.out.println("EmptyStack Test " +e.getMessage());
		}
		
		//Test For NonEmptyStack
		try {
			assertEquals(s2.pop().top(), new String ("Dom"));
		}  catch (Exception e) {
			System.out.println("NonEmptyStack Test " +e.getMessage());
		}
		
		//Test For EmptyListStack
		try {
			System.out.println(j.pop());
		}  catch (Exception e) {
			System.out.println("EmptyListStack Test " +e.getMessage());
		}
		
		//Test For NonEmptyListStack
		try  {
			assertEquals(j1.pop().top(), new String("Shamil"));
		}  catch (Exception e) {
			System.out.println("NonEmptyListStack Test " +e.getMessage());
		}
		
		
		//Tests For Empty Stack Method//
		////////////////////////////////
		
		//Test For EmptyStack
		assertEquals(s.emptyStack(), true);
		
		//Test For NonEmptyStack
		assertEquals(s1.emptyStack(), false);
		
		//Test For EmptyListStack
		assertEquals(j.emptyStack(), true);
		
		//Test For NonEmptyListStack
		assertEquals(j1.emptyStack(), false);
		
		
		//Tests For Push Method//
		/////////////////////////
		
		//Test For EmptyStack
		try  {
			assertEquals(s.push("Nick").top(), new String ("Nick"));
		}  catch (Exception e) {
			System.out.println("Empty Stack Test " +e.getMessage());
		}
		
		//Test For NonEmptyStack
		try  {
			assertEquals(s1.push("Josie").top(), new String ("Josie"));
		}  catch (Exception e) {
			System.out.println("NonEmptyStack Test " +e.getMessage());
		}
		
		//Test For EmptyListStack
		try  {
			assertEquals(j.push("Avi").top(), new String ("Avi"));
		}  catch (Exception e) {
			System.out.println("EmptyListStack Test " +e.getMessage());
		}
		
		//Test For NonEmptyListStack
		try  {
			assertEquals(j1.push("Yohan").top(), new String ("Yohan"));
		}  catch (Exception e) {
			System.out.println("NonEmptyListStack Test " +e.getMessage());
		}
		
		/////////////////
		//Reverse tests//
		/////////////////
		
				//Testing Integer lists
				Stack<Integer> EMTSTACK = new EmptyStack<Integer>();
				IList<Integer> N = new MTLIST<Integer>();
				IList<Integer> N1 = N.cons(new Integer(4)).cons(new Integer(6)).cons(new Integer(3)).cons(new Integer(5));
				IList<Integer> N2 = N.cons(new Integer(5)).cons(new Integer(3)).cons(new Integer(6)).cons(new Integer(4));
				IList<Integer> R2 = reverse.reverseList(N1, EMTSTACK);
				
				//Testing empty Integer list
				IList<Integer> EMTLIST = new MTLIST<Integer>();
				IList<Integer> R3 = reverse.reverseList(EMTLIST, EMTSTACK);
				
				//Testing String lists
				Stack<String> EMTSTRINGSTACK = new EmptyStack<String>();
				IList<String> S = new MTLIST<String>();
				IList<String> S1 = S.cons(new String("dog")).cons(new String("cat")).cons(new String("elephant")).cons(new String("tiger"));
				IList<String> SREV = S.cons(new String("tiger")).cons(new String("elephant")).cons(new String("cat")).cons(new String("dog"));
				IList<String> SREV2 = reverse.reverseList(S1, EMTSTRINGSTACK);
				
				//Testing empty String list
				IList<String> EMTSTRING = new MTLIST<String>();
				IList<String> SREV3 = reverse.reverseList(EMTSTRING, EMTSTRINGSTACK);
				
				try {
					assertEquals(R2.equals(N2), true);
					assertEquals(EMTLIST.equals(R3), true);
					assertEquals(SREV2.equals(SREV), true);
					assertEquals(SREV3.equals(EMTSTRING), true);
					} 
				catch (Exception e) {
					System.out.println("Reverse error: " + e.getMessage());}
				
		}

}
