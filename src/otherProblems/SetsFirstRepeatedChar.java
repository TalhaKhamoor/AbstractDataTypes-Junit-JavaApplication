package otherProblems;

import java.util.HashSet;
import java.util.Set;

public class SetsFirstRepeatedChar {
	
	public static void main(String[] args) {
		
		//example of sets
		Set<Integer> set = new HashSet<>();
		int[] numbers = {1,2,3,3,2,1,4};
		for (int number: numbers) {
			set.add(number);
		}
		System.out.println(set);
		
		
		// finding repeated char
		String str = "green apple";
		
		SetsFirstRepeatedChar m = new SetsFirstRepeatedChar();
		char firstRepeatedChar = m.findRepeatingChar(str);
		
		System.out.println(firstRepeatedChar);
	}
	
	private char findRepeatingChar(String str) {
		Set<Character> set = new HashSet<>();
		
		for (char c : str.toCharArray()) {
			if(set.contains(c))
				return c;
			
			set.add(c);
		}
		
		return Character.MIN_VALUE;
	}

}
