package utilities;

/**
 * 
 * @author Talha Khamoor
 * @version completed Aug 26, 2020
 * @param <E>
 * 
 * My Doubly Linked List ADT that works as a normal DLL would
 * 
 */
public class MyDLL<E> implements ListADT<E> {

	// attributes
	private static final long serialVersionUID = 1L;
	private int size;
	private MyDLLNode<E> front;

	public MyDLL() {
		front = null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {

		MyDLLNode<E> temp = front;
		temp.setElement(null);
		while (temp.getNext() != null) {
			temp.getNext().setElement(null);
		}

	}

	@Override
	public boolean add(int index, E toAdd) throws IndexOutOfBoundsException {

		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (isEmpty()) {
			front = new MyDLLNode<E>(toAdd);
		} else {
			MyDLLNode<E> currentNode = front;
			
			for(int i =0; i < index-1; i++) {
				currentNode = currentNode.getNext();
			}
			
			MyDLLNode<E> newNode = new MyDLLNode<E>(toAdd);

			try {
				MyDLLNode<E> nextNode = currentNode.getNext();
				nextNode.setPrev(newNode);
				currentNode.setNext(newNode);

				newNode.setNext(nextNode);
				newNode.setPrev(currentNode);
				
			}catch(NullPointerException e) {
				newNode.setPrev(currentNode);
				currentNode.setNext(newNode);
			}
			 
		}
		size++;
		return true;

	}

	@Override
	public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		
		MyDLLNode<E> newNode = new MyDLLNode<E>(toAdd);
		if (isEmpty()) {
			front = new MyDLLNode<E>(toAdd);
		} else {
			MyDLLNode<E> current = front;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(newNode);
			newNode.setPrev(current);
		}
		size++;
		return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {

		for (int i = 0; i < toAdd.size(); i++) {
			add(toAdd.get(i));
		}

		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index == 0) {
			return front.getElement();
		} else {

			MyDLLNode<E> temp = front;
			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
			}
			return temp.getElement();
		}

	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {

		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			MyDLLNode<E> newFront = front.getNext();
			front = newFront;
			front.setPrev(null);
			size--;
			return front.getElement();
		} else {

			MyDLLNode<E> current = front;
			MyDLLNode<E> pre = null;
			MyDLLNode<E> post = null;
			
			for (int i = 0; i <index; i++) {
				current = current.getNext();
			}
			pre = current.getPrev();
			post = current.getNext();
			
			pre.setNext(post);
			post.setPrev(pre);
			
			size--;
			return current.getElement();

		}

	}

	@Override
	public E remove(E toRemove) throws NullPointerException {

		MyDLLNode<E> current = front;
		MyDLLNode<E> pre = null;
		MyDLLNode<E> post = null;
		
		
		while(current.getElement() != null) {
			if (current.getElement().equals(toRemove)) {
				try {
					pre = current.getPrev();
				}catch (NullPointerException e){
					front = null;
					front = current.getNext();
					front.setPrev(null);
				}
				try {
					post = current.getNext();
				}catch (NullPointerException e){
					MyDLLNode<E> tail = current.getPrev();
					current = null;
					tail.setNext(null);	
				}

				pre.setNext(current.getNext());
				post.setPrev(current.getPrev());
				size--;
				return current.getElement();
				
			}else {
				current = current.getNext();
			}
		}
				
		
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		MyDLLNode<E> current = front;

		for (int i = 0; i <index; i++) {
			current = current.getNext();
		}
		current.setElement(toChange);
		return current.getElement();
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (front.getElement().equals(toFind)) {
			return true;
		}
		MyDLLNode<E> looking = front;
		for (int i = 0; i < size; i++) {
			looking = looking.getNext();
			if (looking.getElement().equals(toFind)) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {

		if (toHold == null) {
			throw new NullPointerException();
		}
		if (toHold.length < size) {
			toHold = (E[]) new Object[size];
		}
		MyDLLNode<E> transfer = front;
		for (int i = 0; i < size; i++) {
			toHold[i] = transfer.getElement();
			transfer = transfer.getNext();
		}
		return toHold;

	}

	@Override
	public Object[] toArray() {

		MyDLLNode<E> transfer = front;
		Object[] toReturn = new Object[size];
		for (int i = 0; i < size; i++) {
			toReturn[i] = transfer.getElement();
			transfer = transfer.getNext();
		}
		return toReturn;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
