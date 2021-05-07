package utilities;

import java.util.NoSuchElementException;

public class MyQueue<E> implements QueueADT<E> {

	private MyArrayList<E> queue;
	public int size;
	private static final long serialVersionUID = 1L;
	
	public MyQueue() {
		queue = new MyArrayList<E>();	
		size = 0;
	}
	
	@Override
	public void enqueue(E toAdd) throws NullPointerException {
		queue.add(toAdd);
		size++;
		
	}

	@Override
	public E dequeue() throws NoSuchElementException {
		size--;
		return queue.remove(0);
		
	}

	@Override
	public E peek() throws NoSuchElementException {
		return queue.get(0);
	}

	@Override
	public void dequeueAll() {
		queue.clear();
		size=0;
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		return new MyQueueIterator();
	}
	
	private class MyQueueIterator implements Iterator<E>{
		
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
			return queue.get(pos++);
		}
		
	}

	@Override
	public boolean equals(QueueADT<E> that) {
		boolean equal = true;
		for(int i=0; i < that.size()-1; i++) {
			if(!that.dequeue().equals(this.dequeue())) {
				equal = false;
			}
		}
		return equal;
	}

	@Override
	public Object[] toArray() {
		return queue.toArray();
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		return queue.toArray(holder);
	}

	// based off of arraylist so never will be full
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return size;
	}

}
