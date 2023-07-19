import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int max = Integer.MIN_VALUE;
	    int cnt = 0;
	    for (int i=0; i<9; i++) {
	    	int input = Integer.parseInt(br.readLine());
	    	if (max < input) {
	    		max = input;
	    		cnt = i+1;
	    	}
	    }
	    System.out.println(max);
	    System.out.println(cnt);
    }
}
