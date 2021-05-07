package utilities;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * 
 * @author Talha Khamoor
 * @version completed Aug 26, 2020
 * @param <E>
 */
public class MyStack<E> implements StackADT<E>{


	//attributes
	private MyArrayList<E> stack;
	private int size;
	private int top;
	private static final long serialVersionUID = 1L;

	
	public MyStack() {
		stack = new MyArrayList<E>();
		size = 0;
		top = -1;
	}
	
	@Override
	public void push(E toAdd) throws NullPointerException {
		stack.add(toAdd);
		size++;
		top++;
	}

	@Override
	public E pop() throws EmptyStackException {
		return stack.remove(top--);
	}

	@Override
	public E peek() throws EmptyStackException {
		return stack.get(top);
	}

	@Override
	public void clear() {
		stack.clear();
		size=0;
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public Object[] toArray() {
		return stack.toArray();
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		return stack.toArray(holder);
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		return stack.contains(toFind);
	}

	@Override
	public int search(E toFind) {
		
		for (int i = 0; i < size; i++) {
			System.out.println(stack.get(i));
			if (stack.get(i).equals(toFind)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyStackIterator();
	}
	
	private class MyStackIterator implements Iterator<E>{

		//attribute
		private int pos;
		
		@Override
		public boolean hasNext() {
			return pos < size;
		}

		@Override
		public E next() throws NoSuchElementException {
			if(pos >= size) {
				throw new NoSuchElementException();
			}
			return stack.get(pos++);			
		}
		
	}

	@Override
	public boolean equals(StackADT<E> that) {
		
		boolean equal = true;
		for (int i=0; i < that.size()-1; i++) {
			if (!that.pop().equals(this.pop())){
				equal = false;
			}
		}
		
		return equal;
	}

	@Override
	public int size() {
		return size;
	}

	
}
