import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String input = br.readLine();
    	StringBuffer sb1 = new StringBuffer(input.split(" ")[0]);
    	StringBuffer sb2 = new StringBuffer(input.split(" ")[1]);
    	if (Integer.parseInt(sb1.reverse().toString()) < Integer.parseInt(sb2.reverse().toString())) {
    		System.out.println(sb2);
    	} else System.out.println(sb1);
    }
}
