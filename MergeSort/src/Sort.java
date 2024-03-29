import java.util.Comparator;

/**
 * Class for sorting lists that implement the IndexedUnsortedList interface,
 * using ordering defined by class of objects in list or a Comparator.
 * As written uses Merge Sort algorithm.
 *
 * @author CS221
 */
public class Sort
{	
	/**
	 * Returns a new list that implements the IndexedUnsortedList interface. 
	 * As configured, uses WrappedDLL. 
	 * Must be changed if using your own IUDoubleLinkedList class. 
	 * 
	 * @return a new list that implements the IndexedUnsortedList interface
	 */
	public static <T> IndexedUnsortedList<T> newList() 
	{
		//TODO: replace with your IUDoubleLinkedList for extra-credit
		return new IUDoubleLinkedList<T>(); 
	}
	
	/**
	 * Sorts a list that implements the IndexedUnsortedList interface 
	 * using compareTo() method defined by class of objects in list.
	 * DO NOT MODIFY THIS METHOD
	 * 
	 * @param <T>
	 *            The class of elements in the list, must extend Comparable
	 * @param list
	 *            The list to be sorted, implements IndexedUnsortedList interface 
	 * @see IndexedUnsortedList 
	 */
	public static <T extends Comparable<T>> void sort(IndexedUnsortedList<T> list) 
	{
		mergesort(list);
	}

	/**
	 * Sorts a list that implements the IndexedUnsortedList interface 
	 * using given Comparator.
	 * DO NOT MODIFY THIS METHOD
	 * 
	 * @param <T>
	 *            The class of elements in the list
	 * @param list
	 *            The list to be sorted, implements IndexedUnsortedList interface 
	 * @param c
	 *            The Comparator used
	 * @see IndexedUnsortedList 
	 */
	public static <T> void sort(IndexedUnsortedList <T> list, Comparator<T> c) 
	{
		mergesort(list, c);
	}
	
	/**
	 * Merge Sort algorithm to sort objects in a list 
	 * that implements the IndexedUnsortedList interface, 
	 * using compareTo() method defined by class of objects in list.
	 * DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The class of elements in the list, must extend Comparable
	 * @param list
	 *            The list to be sorted, implements IndexedUnsortedList interface 
	 */
	private static <T extends Comparable<T>> void mergesort(IndexedUnsortedList<T> list)
	{
		int size = list.size();
		int mid = size / 2;
		
		if (size < 2) {
			return;
		}
		// sub-lists about half the size of list
		IndexedUnsortedList<T> lowerList = newList(); 
		IndexedUnsortedList<T> upperList = newList();
		
		
		for (int i = 0; i < mid; i++) {
			lowerList.addToRear(list.removeFirst());
		}
		while (!list.isEmpty()) {
			upperList.addToRear(list.removeFirst());
		}
		mergesort(lowerList);
		mergesort(upperList);
		
		
		merge(list, lowerList, upperList); 
	}
	
	/**
	 * Implements merge method for Merge Sort algorithm.  
	 * DO NOT MODIFY THIS METHOD SIGNATURE
	 *
	 * @param list - reference to original list that's being sorted, now empty 
	 * @param lowerList - lower half of original list 
	 * @param upperList - upper half of original list 
	 */
	private static <T extends Comparable<T>> void merge(IndexedUnsortedList<T> list, IndexedUnsortedList<T> lowerList, IndexedUnsortedList<T> upperList)
	{
		while (!lowerList.isEmpty() && !upperList.isEmpty()) {
			if (lowerList.get(0).compareTo(upperList.get(0)) < 0) {
				list.addToRear(lowerList.removeFirst());
			} else {
				list.addToRear(upperList.removeFirst());
			}
		}
		
		while (!lowerList.isEmpty()) {
			list.addToRear(lowerList.removeFirst());
		}
		while (!upperList.isEmpty()) {
			list.addToRear(upperList.removeFirst());
		}
	}
		
	/**
	 * Merge Sort algorithm to sort objects in a list 
	 * that implements the IndexedUnsortedList interface,
	 * using the given Comparator.
	 * DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The class of elements in the list
	 * @param list
	 *            The list to be sorted, implements IndexedUnsortedList interface 
	 * @param c
	 *            The Comparator used
	 */
	private static <T> void mergesort(IndexedUnsortedList<T> list, Comparator<T> c)
	{		
		
		int size = list.size();
		int mid = size / 2;
		
		if (size < 2) {
			return;
		}
		// sub-lists about half the size of list
		IndexedUnsortedList<T> lowerList = newList(); 
		IndexedUnsortedList<T> upperList = newList();
		
		
		for (int i = 0; i < mid; i++) {
			lowerList.addToRear(list.removeFirst());
		}
		while (!list.isEmpty()) {
			upperList.addToRear(list.removeFirst());
		}
		mergesort(lowerList, c);
		mergesort(upperList, c);
		
		
		
		merge(list, lowerList, upperList, c); 
		
	}
	
	/**
	 * Implements merge method for Merge Sort algorithm 
	 * @param list - reference to original list that's being sorted, now empty 
	 * @param lowerList - lower half of original list 
	 * @param upperList - upper half of original list 
	 * @param c - Comparator for comparing elements in list
	 */
	private static <T> void merge(IndexedUnsortedList<T> list, IndexedUnsortedList<T> lowerList, IndexedUnsortedList<T> upperList, Comparator<T> c)
	{
		while (!lowerList.isEmpty() && !upperList.isEmpty()) {
			if (c.compare(lowerList.get(0), (upperList.get(0))) < 0) {
				list.addToRear(lowerList.removeFirst());
			} else {
				list.addToRear(upperList.removeFirst());
			}
		}
		
		while (!lowerList.isEmpty()) {
			list.addToRear(lowerList.removeFirst());
		}
		while (!upperList.isEmpty()) {
			list.addToRear(upperList.removeFirst());
		}
	
	}
	
}