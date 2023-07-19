import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
		int[] input = new int[N+1];
		for (int i=0; i<=N; i++) {
			input[i] = i;
		}
		for (int h=0; h<M; h++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st2.nextToken());
			int j = Integer.parseInt(st2.nextToken());
			int[] copyInput = input.clone();
			for (int k=1; k<=j-i+1; k++) {
				input[k+i-1] = copyInput[j-k+1];
			}
		}
		System.out.println(Arrays.toString(Arrays.copyOfRange(input, 1, N+1)).replaceAll("[^0-9 ]",""));
    }
}