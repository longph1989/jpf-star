package star.examples.linkedlist;

//MyLinkedListItr.java
//This class implements iterator to a linked list .

class MyLinkedListItr {
	/* Class Memeber */
	public MyListNode _current; // Current position

	MyLinkedListItr() {
		this(null);
	}
	
	// C'tor
	MyLinkedListItr(MyListNode theNode) {
		this._current = theNode;
	}

	/* Methods */

	public boolean isPastEnd() {
		return this._current == null;
	}

	public Object retrieve() {
		return isPastEnd() ? null : this._current._element;
	}

	public void advance() {
		if (!isPastEnd())
			this._current = this._current._next;
	}

}
