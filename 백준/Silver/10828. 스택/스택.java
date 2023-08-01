import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	Stack<Integer> stack = new Stack<>();
    	
    	for (int i=0; i<N; i++) {
    		String input = br.readLine();
    		if (input.contains("push")) {
    			stack.push(Integer.parseInt(input.split(" ")[1]));
    		} else if (input.equals("top")) {
    			if (stack.empty()) {
    				System.out.println(-1);
    			} else {
    				System.out.println(stack.peek());
    			}
    		} else if (input.equals("size")) {
    			System.out.println(stack.size());
    		} else if (input.equals("empty")) {
    			if (stack.empty()) {
    				System.out.println(1);
    			} else {
    				System.out.println(0);
    			}
    		} else if (input.equals("pop")) {
    			if (stack.size() != 0) {
        			System.out.println(stack.pop());
    			} else {
    				System.out.println(-1);
    			}
    		}
    	}
    }
}