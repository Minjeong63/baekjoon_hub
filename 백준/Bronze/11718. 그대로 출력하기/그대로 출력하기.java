import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    for (int i=0; i<100; i++) {
	    	String input = br.readLine();
	    	if (input == null) break;
	    	System.out.println(input);
	    }
    	    	    	
    }
}
