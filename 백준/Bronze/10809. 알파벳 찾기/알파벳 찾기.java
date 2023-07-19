import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] result = {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"};
    	for (int i=0; i<input.length(); i++) {
    		if (result[((int)input.charAt(i)-97)] == "-1") {
    			result[((int)input.charAt(i)-97)] = String.valueOf(i);
    		}
    	}
        System.out.println(String.join(" ", result));
    }
}
