import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    String[] input = br.readLine().split(" ");
	    int max = -1000000;
	    int min = 1000000;
	    for (int i=0; i<N; i++) {
	    	if (max < Integer.parseInt(input[i])) max = Integer.parseInt(input[i]);
	    	if (min > Integer.parseInt(input[i])) min = Integer.parseInt(input[i]);
	    }
		System.out.println(min + " "+ max);
    }
}
