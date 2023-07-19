import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int N = Integer.parseInt(input[0]);
	    int X = Integer.parseInt(input[1]);
	    String[] A = br.readLine().split(" ");
	    ArrayList<String> result = new ArrayList<>();
	    for (int i=0; i<N; i++) {
	    	if (Integer.parseInt(A[i]) < X) result.add(A[i]);
	    }
		System.out.println(String.join(" ", result));
    }
}
