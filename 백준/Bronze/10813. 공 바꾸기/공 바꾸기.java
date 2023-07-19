import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] input1 = br.readLine().split(" ");
    	int N = Integer.parseInt(input1[0]);
    	int M = Integer.parseInt(input1[1]);
    	String[] result = new String[N];
    	for (int i=0; i<N; i++) {
    		result[i] = Integer.toString(i+1);
    	}
    	for (int j=0; j<M; j++) {
    		String[] input2 = br.readLine().split(" ");
    		String value = result[(Integer.parseInt(input2[0])-1)];
    		result[(Integer.parseInt(input2[0])-1)] = result[(Integer.parseInt(input2[1])-1)];
    		result[(Integer.parseInt(input2[1])-1)] = value;
    	}
    	System.out.println(String.join(" ", result));

    }
}