import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringTokenizer st2 =  new StringTokenizer(br.readLine());
		int[] input = new int[N];
		for (int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st2.nextToken());
		}
		int i = 0;
		int j = 1;
		int k = 2;
		int sum = 0;
		while (true) {
			if (input[i] + input[j] + input[k] <= M) {
				sum = Math.max(input[i] + input[j] + input[k], sum);
			}
			if (k == N-1 && j != N-2) {
				j++;
				k = j;
			} else if (k == N-1 && j == N-2) {
				if (i == N-3) break;
				i++;
				j = i+1;
				k = j;
			}
			k++;
		}
		System.out.println(sum);
	}
}