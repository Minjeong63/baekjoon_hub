import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	Stack<Integer> stack = new Stack<>();
    	int start = 0;
    	
    	for (int i=0; i<n; i++) {
    		int input = Integer.parseInt(br.readLine());
    		
    		if (start < input) {
    			for (int j= start + 1; j <= input; j++) {
        			stack.push(j);
        			sb.append("+" + "\n");
        		}
    			start = input;
    			
    		} else {
    			if (stack.peek() != input) {
    				sb.setLength(0);
    				sb.append("NO");
    				break;
    			}
    		}
    		
    		
    		if (stack.peek() == input) {
    			stack.pop();
    			sb.append("-" + "\n");
    		}
    	}
    	System.out.println(sb);
    }
}