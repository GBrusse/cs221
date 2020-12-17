import java.util.ListIterator;

public class MyListIterator<T> implements ListIterator<T> {
	private IUDoubleLinkedList<T> list;
	public int curr;

	public MyListIterator(IUDoubleLinkedList<T> newList) {
		list = newList;
		curr = 0;
	}
	/**
	 * Returns true if this list iterator has more elements when traversing
	 * the list in the forward direction.
	 */
	@Override
	public boolean hasNext() {
		return (curr < list.size());
	}
	/**
	 * Returns the next element in the list and advances the cursor position.
	 */
	@Override
	public T next() {
		T temp = list.get(curr);
		curr++;
		return temp;
	}
	/**
	 * Inserts the specified element into the list (optional operation)
	 * @param element   The element to be added into the list.
	 */
	public void add(T element) {
		list.add(curr, element);
	}
	/**
	 * Removes from the list the last element that was returned
	 * by next() or previous() (optional operation).
	 */
	public void remove() {
		list.remove(curr - 1);
	}
	/**
	 * Replaces the last element returned by next() or previous() with the
	 * specified element (optional operation).
	 * 
	 * @param element     The element to be set
	 */
	public void set(T element) {
		list.set(curr - 1, element);
	}
	/**
	 * Returns true if this list iterator has more elements when traversing the 
	 * list in the reverse direction.
	 */
	@Override
	public boolean hasPrevious() {
		return (curr > 0);
	}
	/**
	 * Returns the previous element in the list and moves the cursor
	 * position backwards.
	 */
	@Override
	public T previous() {
		return list.get(curr - 1);
	}
	/**
	 * Returns the index of the element that would be returned by
	 * a subsequent call to next().
	 */
	@Override
	public int nextIndex() {
		return curr;
	}
	/**
	 * Returns the index of the element that would be returned by
	 * a subsequent call to previous().
	 */
	@Override
	public int previousIndex() {
		return curr - 1;
	}

}