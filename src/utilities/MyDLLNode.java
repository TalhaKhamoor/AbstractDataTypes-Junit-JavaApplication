package utilities;

/**
 * 
 * @author Talha Khamoor
 * @version completed Aug 26, 2020
 * @param <E>
 */
public class MyDLLNode<E> {

	private E element;
	private MyDLLNode<E> next;
	private MyDLLNode<E> prev;
	
	public MyDLLNode(E element){
		this.element = element;
		this.next = null;
		this.prev = null;
	}
	
	public MyDLLNode(MyDLLNode<E> prev, E element, MyDLLNode<E> next){
		this.element = element;
		this.prev = prev;
		this.next = next;
	}
	
	public E getElement() {
		return element;
	}
	
	public void setElement(E element) {
		this.element = element;
	}
	
	public MyDLLNode<E> getNext() {
		return next;
	}
	
	public MyDLLNode<E> getPrev() {
		return prev;
	}
	
	public void setNext(MyDLLNode<E> next){
		this.next = next;
	}
	
	public void setPrev(MyDLLNode<E> prev) {
		this.prev = prev;
	}
	
}
