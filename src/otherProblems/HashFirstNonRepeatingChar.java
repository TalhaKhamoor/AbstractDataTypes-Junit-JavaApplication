package otherProblems;

import java.util.HashMap;
import java.util.Map;

public class HashFirstNonRepeatingChar {

	public static void main(String[] args) {
		// a green apple
		// a=2
		//  =2
		// g=1 
		
		String str = "a green apple";
		Map<Character, Integer> map = new HashMap<>();
		
		char[] chars = str.toCharArray();
		
		for(char ch : chars) {	
			int count = map.containsKey(ch) ? map.get(ch) : 0;
			map.put(ch, count+1);
		}
		for(char ch: chars) {
			if (map.get(ch)==1) {
				System.out.println(ch);
				return;
			}
		}
		
	}
	
}
