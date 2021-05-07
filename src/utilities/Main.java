package utilities;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		
		int item = queue.dequeue();
		System.out.println(item);
		System.out.println(Arrays.toString(queue.toArray()));

		
	}
}
