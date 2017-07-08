package gov.nasa.jpf.star.examples;

import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;

public class Sll2_myMethod1 extends TestJPF {

	@Test
	public void test1() throws Exception {
		Node x = null;
		Sll2.myMethod(x);
	}

	@Test
	public void test2() throws Exception {
		Node x = new Node();
		Node next_1 = null;
		x.next = next_1;
		Sll2.myMethod(x);
	}

	@Test
	public void test3() throws Exception {
		Node x = new Node();
		Node next_1 = new Node();
		Node next_2 = null;
		x.next = next_1;
		next_1.next = next_2;
		Sll2.myMethod(x);
	}

	@Test
	public void test4() throws Exception {
		Node x = new Node();
		Node next_1 = new Node();
		Node next_2 = new Node();
		Node next_3 = null;
		x.next = next_1;
		next_1.next = next_2;
		next_2.next = next_3;
		Sll2.myMethod(x);
	}

}

