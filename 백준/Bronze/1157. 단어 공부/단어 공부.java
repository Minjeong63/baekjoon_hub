import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine().toUpperCase();
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for (int i=0; i<input.length(); i++) {
			if (map.containsKey(input.charAt(i))) {
				map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
			} else {
				map.put(input.charAt(i), 1);
			}
		}
		int max = Integer.MIN_VALUE;
		for (Integer value: map.values()) {
			if (value > max) {
				max = value;
			}
		}
		
		int numberOfMax = 0;
		StringBuffer sb = new StringBuffer();
		for (Character key: map.keySet()) {
			if (map.get(key) == max) {
				sb.append(key);
				numberOfMax++;
			}
		}
		
		if (numberOfMax == 1) System.out.println(sb);
		else System.out.println("?");
	}
}