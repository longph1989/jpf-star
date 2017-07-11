package gov.nasa.jpf.star.examples.rbt;

import gov.nasa.jpf.star.examples.rbt.TreeMap.Entry;
import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;

public class TreeMap_firstKey1 extends TestJPF {

	@Test
	public void test1() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = null;
		obj.size = 0;
		obj.modCount = 0;
		obj.firstKey();
	}

	@Test
	public void test2() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = new Entry();
		Entry parent_5 = null;
		Entry left_3 = null;
		Entry right_4 = null;
		boolean color_6 = true;
		obj.size = 1;
		int key_1 = 3;
		obj.modCount = 0;
		Object value_2 = null;
		obj.root.key = key_1;
		obj.root.value = value_2;
		obj.root.left = left_3;
		obj.root.right = right_4;
		obj.root.parent = parent_5;
		obj.root.color = color_6;
		obj.firstKey();
	}

	@Test
	public void test3() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = new Entry();
		Entry left_3 = new Entry();
		Entry right_4 = new Entry();
		Entry parent_5 = null;
		Entry parent_17 = obj.root;
		Entry left_15 = null;
		Entry left_300 = left_3;
		Entry right_16 = null;
		Entry left_376 = null;
		Entry right_374 = null;
		obj.size = 3;
		boolean color_6 = true;
		boolean color_377 = true;
		boolean color_18 = true;
		int key_13 = -1;
		int key_1 = 0;
		int key_373 = 1;
		obj.modCount = 0;
		Object value_2 = null;
		Object value_14 = null;
		Object value_378 = null;
		obj.root.key = key_1;
		obj.root.value = value_2;
		obj.root.left = left_3;
		obj.root.right = right_4;
		obj.root.parent = parent_5;
		obj.root.color = color_6;
		left_3.key = key_13;
		left_3.value = value_14;
		left_3.left = left_15;
		left_3.right = right_16;
		left_3.parent = parent_17;
		left_3.color = color_18;
		right_4.key = key_373;
		right_4.value = value_378;
		right_4.left = left_376;
		right_4.right = right_374;
		right_4.parent = obj.root;
		right_4.color = color_377;
		obj.firstKey();
	}

	@Test
	public void test4() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = new Entry();
		Entry left_3 = new Entry();
		Entry left_15 = new Entry();
		Entry right_4 = new Entry();
		Entry parent_5 = null;
		Entry parent_17 = obj.root;
		Entry parent_27 = left_3;
		Entry left_25 = null;
		Entry left_300 = left_3;
		Entry left_303 = left_15;
		Entry right_16 = null;
		Entry right_26 = null;
		Entry left_412 = null;
		Entry right_410 = null;
		boolean color_413 = true;
		obj.size = 4;
		boolean color_6 = true;
		boolean color_18 = true;
		int key_23 = -1;
		int key_13 = 0;
		int key_1 = 1;
		boolean color_28 = false;
		int key_409 = 2;
		obj.modCount = 0;
		Object value_2 = null;
		Object value_14 = null;
		Object value_24 = null;
		Object value_414 = null;
		obj.root.key = key_1;
		obj.root.value = value_2;
		obj.root.left = left_3;
		obj.root.right = right_4;
		obj.root.parent = parent_5;
		obj.root.color = color_6;
		left_3.key = key_13;
		left_3.value = value_14;
		left_3.left = left_15;
		left_3.right = right_16;
		left_3.parent = parent_17;
		left_3.color = color_18;
		left_15.key = key_23;
		left_15.value = value_24;
		left_15.left = left_25;
		left_15.right = right_26;
		left_15.parent = parent_27;
		left_15.color = color_28;
		right_4.key = key_409;
		right_4.value = value_414;
		right_4.left = left_412;
		right_4.right = right_410;
		right_4.parent = obj.root;
		right_4.color = color_413;
		obj.firstKey();
	}

	@Test
	public void test5() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = new Entry();
		Entry left_3 = new Entry();
		Entry parent_5 = null;
		Entry parent_17 = obj.root;
		Entry left_15 = null;
		Entry left_300 = left_3;
		Entry right_4 = null;
		Entry right_16 = null;
		obj.size = 2;
		boolean color_18 = false;
		int key_13 = 0;
		int key_1 = 1;
		boolean color_6 = true;
		obj.modCount = 0;
		Object value_2 = null;
		Object value_14 = null;
		obj.root.key = key_1;
		obj.root.value = value_2;
		obj.root.left = left_3;
		obj.root.right = right_4;
		obj.root.parent = parent_5;
		obj.root.color = color_6;
		left_3.key = key_13;
		left_3.value = value_14;
		left_3.left = left_15;
		left_3.right = right_16;
		left_3.parent = parent_17;
		left_3.color = color_18;
		obj.firstKey();
	}

	@Test
	public void test6() throws Exception {
		TreeMap obj = new TreeMap();
		obj.root = new Entry();
		Entry left_3 = new Entry();
		Entry left_15 = new Entry();
		Entry right_4 = new Entry();
		Entry right_16 = new Entry();
		Entry parent_5 = null;
		Entry parent_17 = obj.root;
		Entry parent_47 = left_3;
		Entry left_45 = null;
		Entry left_300 = left_3;
		Entry left_303 = left_15;
		Entry right_46 = null;
		Entry left_412 = null;
		Entry right_410 = null;
		Entry left_427 = null;
		Entry right_425 = null;
		obj.size = 5;
		boolean color_6 = true;
		int key_424 = 1;
		int key_43 = -1;
		int key_409 = 3;
		boolean color_428 = true;
		boolean color_413 = true;
		boolean color_48 = true;
		boolean color_18 = false;
		int key_13 = 0;
		int key_1 = 2;
		obj.modCount = 0;
		Object value_2 = null;
		Object value_14 = null;
		Object value_44 = null;
		Object value_414 = null;
		Object value_429 = null;
		obj.root.key = key_1;
		obj.root.value = value_2;
		obj.root.left = left_3;
		obj.root.right = right_4;
		obj.root.parent = parent_5;
		obj.root.color = color_6;
		left_3.key = key_13;
		left_3.value = value_14;
		left_3.left = left_15;
		left_3.right = right_16;
		left_3.parent = parent_17;
		left_3.color = color_18;
		left_15.key = key_43;
		left_15.value = value_44;
		left_15.left = left_45;
		left_15.right = right_46;
		left_15.parent = parent_47;
		left_15.color = color_48;
		right_4.key = key_409;
		right_4.value = value_414;
		right_4.left = left_412;
		right_4.right = right_410;
		right_4.parent = obj.root;
		right_4.color = color_413;
		right_16.key = key_424;
		right_16.value = value_429;
		right_16.left = left_427;
		right_16.right = right_425;
		right_16.parent = left_300;
		right_16.color = color_428;
		obj.firstKey();
	}

}

