import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] input = new String[30];
    	Arrays.fill(input, "0");
    	ArrayList<String> result = new ArrayList<String>();
    	for (int i=1; i<=28; i++) {
    		String input2 = br.readLine();
    		input[Integer.parseInt(input2)-1] = "1";
    	}
    	for (int i=0; i<30; i++) {
    		if (input[i] == "0") result.add(Integer.toString(i+1));
    	}
    	System.out.println(String.join("\n", result));
    }
}