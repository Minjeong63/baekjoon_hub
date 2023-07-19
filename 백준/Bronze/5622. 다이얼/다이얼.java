import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String input = br.readLine().strip();
	    int result = 0;
	    for (int i=0; i<input.length(); i++) {
	    	if ((int) input.charAt(i) <= 67 && (int) input.charAt(i) >= 65) result += 3;
	    	else if ((int) input.charAt(i) <= 70) result += 4;
	    	else if ((int) input.charAt(i) <= 73) result += 5; 
	    	else if ((int) input.charAt(i) <= 76) result += 6; 
	    	else if ((int) input.charAt(i) <= 79) result += 7; 
	    	else if ((int) input.charAt(i) <= 83) result += 8; 
	    	else if ((int) input.charAt(i) <= 86) result += 9; 
	    	else if ((int) input.charAt(i) <= 90) result += 10; 
	    }
	    System.out.println(result);
    }
}
