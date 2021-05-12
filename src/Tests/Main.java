package Tests;

import utilities.HashTableADT;

public class Main {

	public static void main(String[] args) {
		HashTableADT table = new HashTableADT();
		table.put(6, "A");//1
		table.put(8, "B");//3
		table.put(11, "C");//1 collision
		table.put(8, "B+");//3

		System.out.println("Done");


	}
}
