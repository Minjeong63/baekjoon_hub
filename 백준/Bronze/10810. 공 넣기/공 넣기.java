import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input1 = br.readLine().split(" ");
	    int N = Integer.parseInt(input1[0]);
	    int M = Integer.parseInt(input1[1]);
	    String[] result = new String[N];
	    Arrays.fill(result, "0");
	    for (int i=0; i<M; i++) {
	    	String[] input2 = br.readLine().split(" ");
	    	for (int j=Integer.parseInt(input2[0]); j<=Integer.parseInt(input2[1]); j++) {
	    		result[j-1] = input2[2];
	    	}
	    }
	    System.out.println(String.join(" ", result));
    }
}
