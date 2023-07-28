import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] inputArr = new int[N];
		
		for (int i=0; i<N; i++) {
			inputArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(inputArr);
		
		int i = 0, j = N - 1;
		int[] answer = new int[2];
		int minimum = Integer.MAX_VALUE;
		
		while (i < j) {
			int sum = inputArr[i] + inputArr[j];
			
			if (Math.abs(sum) < minimum) {
				answer[0] = inputArr[i];
				answer[1] = inputArr[j];
				minimum = Math.abs(sum);
			}
			if (sum > 0) {
				j--;
			} else {
				i++;
			}
		}
		System.out.println(Math.min(answer[0], answer[1]) + " " + Math.max(answer[0], answer[1]));
	}
}
