import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ListIterator;

/**
 * 
 * @author GaryBrusse
 *
 * @param <T>    The generic type of the collection.
 */
public class IUDoubleLinkedList<T> implements IndexedUnsortedList<T> {
	private DLLNode<T> head;
	private DLLNode<T> tail;
	private int length;
	
	public IUDoubleLinkedList() {
		head = null;
		tail = null;
		length = 0;
	}
	/**
	 * Given an element to add to the front of the list.
	 * 
	 * @param element   The element to be added to the list.
	 * @return          No return type.
	 */
	@Override
	public void addToFront(T element) {
		DLLNode<T> newNode = new DLLNode<T>(element);
		length++;
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
	}
	/**
	 * Given an element to add to the end of the list.
	 * 
	 * @param element   The element to be added to the list.
	 * @return          No return type.
	 */
	@Override
	public void addToRear(T element) {
		DLLNode<T> newNode = new DLLNode<T>(element);
		length++;
		if (tail == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}
	/**
	 * Given an element to add to the list. Defaulted to the end of the list.
	 * 
	 * @param element    The element to be added to the list.
	 * @return           No return type.
	 */
	@Override
	public void add(T element) {
		addToRear(element);
	}

	/**
	 * Given a target and an element, the element will be added to the list after the first instance of target.
	 * 
	 * @param element    The element to be added after the target.
	 * @param target     The node that will be searched for within the list.
	 * @return           This method has no return value.
	 */
	@Override
	public void addAfter(T element, T target) {
		for (DLLNode<T> x = head; x != null; x= x.next) {
			if (x.data == target) {
				DLLNode<T> newNode = new DLLNode<T>(element);
				newNode.next = x.next;
				newNode.prev = x;
				if (x.next != null) {
					x.next.prev = newNode;
				} else {
					tail = newNode;
				}
				x.next = newNode;
				length++;
				return;
			}
		}
		throw new NoSuchElementException();
	}
	/**
	 * Given an element to add to the list, or given
	 * an index to place a given element.
	 * 
	 * @param index     A position in the list.
	 * @param element   The element to be added.
	 * @return          No return type.
	 */
	@Override
	public void add(int index, T element) {
		if (index < 0 || index > length) {
			throw new IndexOutOfBoundsException();
		}
		for (DLLNode<T> x = head; x != null; x= x.next) {
			if (index == 0) {
				DLLNode<T> newNode = new DLLNode<T>(element);
				if (length == 0) {
					head = newNode;
					tail = newNode;
				} else {
					newNode.next = x.next;
					newNode.prev = x;
					if (x.next != null) {
						x.next.prev = newNode;
					} else {
						tail = newNode;
					}
					x.next = newNode;
				}
				length++;
				return;
			}
			index--;
		}
	}
	/**
	 * Remove the element in the first position on the list.
	 * @param             No parameter
	 * @return headData   What the new element at the first position is.
	 */
	@Override
	public T removeFirst() {
		if (head == null) {
			throw new NoSuchElementException();
		}
		T headData = head.data;
		head = head.next;
		head.prev = null;
		length--;
		return headData;
	}
	/**
	 * Remove the element in the last position on the list.
	 * @param             No parameter
	 * @return headData   What the new element at the last position is.
	 */
	@Override
	public T removeLast() {
		if (tail == null) {
			throw new NoSuchElementException();
		}
		T tailData = tail.data;
		tail = tail.prev;
		tail.next = null;
		length--;
		return tailData;
	}

	@Override
	public T remove(T element) {
		for (DLLNode<T> x = head; x != null; x = x.next) {
			if (x.data == element) {
				T nodeData = x.data;
				if (x.prev == null) {
					head = x.next;
				} else {
					x.prev.next = x.next;
				}
				if (x.next == null) {
					tail = x.prev;
				} else {
					x.next.prev = x.prev;
				}
				length--;
				return nodeData;
			}
		}
		throw new NoSuchElementException();
	}

	@Override
	public T remove(int index) {
		for (DLLNode<T> x = head; x != null; x= x.next) {
			if (index == 0) {
				T nodeData = x.data;
				if (x.prev != null) {
					x.prev.next = x.next;
				} else {
					head = x.next;
				}
				if (x.next != null) {
					x.next.prev = x.prev;
				} else {
					tail = x.prev;
				}
				length--;
				return nodeData;
			}
			index--;
		}
		throw new IndexOutOfBoundsException();
	}

	@Override
	public void set(int index, T element) {
		if (index < 0 || index >= length) {
			throw new IndexOutOfBoundsException();
		}
		for (DLLNode<T> x = head; x != null; x = x.next) {
			if (index == 0) {
				x.data = element;
			}
			index--;
		}
	}

	@Override
	public T get(int index) {
		for (DLLNode<T> x = head; x != null; x = x.next) {
			if (index == 0) {
				return x.data;
			}
			index--;
		}
		throw new IndexOutOfBoundsException();
	}

	@Override
	public int indexOf(T element) {
		int index = 0;
		for (DLLNode<T> x = head; x != null; x = x.next) {
			if (x.data == element) {
				return index;
			}
			index++;
		}
		return -1;
	}

	@Override
	public T first() {
		if (head == null) {
			throw new NoSuchElementException();
		}
		return head.data;
	}

	@Override
	public T last() {
		if (tail == null) {
			throw new NoSuchElementException();
		}
		return tail.data;
	}

	@Override
	public boolean contains(T target) {
		for (DLLNode<T> x = head; x != null; x = x.next) {
			if (x.data == target) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return length == 0;
	}

	@Override
	public int size() {
		return length;
	}

	@Override
	public Iterator<T> iterator() {
		return (Iterator<T>) new MyListIterator<T>(this);
	}

	@Override
	public ListIterator<T> listIterator() {
		return (ListIterator<T>) new MyListIterator<T>(this);
	}

	@Override
	public ListIterator<T> listIterator(int startingIndex) {
		if (startingIndex < 0 || startingIndex >= this.size()) {
			throw new IndexOutOfBoundsException();
		}
		MyListIterator<T> iter = new MyListIterator<T>(this);
		iter.curr = startingIndex;
		return (ListIterator<T>) iter;
	}
}