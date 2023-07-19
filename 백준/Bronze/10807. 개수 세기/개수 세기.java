import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int num = Integer.parseInt(br.readLine());
	    String[] input = br.readLine().strip().split(" ");
	    int v = Integer.parseInt(br.readLine());
	    int result = 0;
	    for (int i=0; i<num; i++) {
	    	if (Integer.parseInt(input[i]) == v) result++;
	    }
	    System.out.println(result);
    }
}
