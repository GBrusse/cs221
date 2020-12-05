/**
 * Used internally by IUDoubleLinkedList
 * 
 * @author Gary
 * 
 * @param <T>
 */
public class DLLNode<T> {
	public DLLNode<T> prev;
	public DLLNode<T> next;
	public T data;

	public DLLNode(T newData) {
		prev = null;
		next = null;
		data = newData;
	}
}