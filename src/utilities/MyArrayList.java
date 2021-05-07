package utilities;

import java.util.NoSuchElementException;

/**
 * 
 * @author Talha Khamoor
 * @version completed Aug 26, 2020
 * @param <E>
 * 
 * My array list class that works as a normal ArrayList would
 * 
 */
public class MyArrayList<E> implements ListADT<E> {
	
	//attributes
	private E[] array;
	private int size;
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		array = (E[]) new Object[10];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		size = 0;
		
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		add(toAdd);
		
		for (int i = size-1; i > index ; i--) {
			array[i] = array[i-1];
		}
		
		array[index] = toAdd;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (size >= array.length) {
			E[] bigger = (E[]) new Object[array.length * 2];
			for (int i=0; i < array.length; i++) {
				Object item = array[i];
				bigger[i] = (E) item;
			}
			array = bigger;
		}
		array[size++] = toAdd;
		return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		
		for (int i =0; i < toAdd.size(); i++) {
			add(toAdd.get(i));
		}
		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		return array[index];
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		
		E element = get(index);
		for (int i = index; i < size-1; i++) {
			array[i] = array[i+1];
		}
		size--;
		return element;
		
	}
	

	@Override
	public E remove(E toRemove) throws NullPointerException {
	
		for (int i = 0; i < size-1; i++) {
			if (array[i].equals(toRemove)) {
				remove(i);
				break;
			}
		}
		
		return toRemove;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		E old = get(index);
		array[index] = toChange;
		return old;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		for (int i = 0; i < size; i++) {
			if (array[i].equals(toFind)) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if(toHold == null) {
			throw new NullPointerException();
		}
		if(toHold.length < size) {
			toHold = (E[]) new Object[size];
		}
		
		for(int i = 0; i < size; i++) {
			toHold[i] = array[i];
		}
		return toHold;
	}

	@Override
	public Object[] toArray() {
		
		Object[] toReturn = new Object[size];
		
		for(int i = 0; i < size; i++) {
			toReturn[i] = array[i];
		}
		return toReturn;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyArrayListIterator();
	}
	
	private class MyArrayListIterator implements Iterator<E>{

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
			return array[pos++];
			
		}
		
	}

}
