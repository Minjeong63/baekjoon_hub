import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     	int N = Integer.parseInt(br.readLine());
     	int dupl = 0;
     	for (int i=0; i<N; i++) {
     		String input = br.readLine();
     		for (int j=0; j<input.length(); j++) {
     			if (input.indexOf(input.charAt(j)) != j && input.charAt(j-1) != input.charAt(j)) {
     				dupl++;
     				break;
     			}
     		}
     	}
     	System.out.println(N-dupl);
    }
}