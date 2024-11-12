import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int L;
	static int max;
	static int[][] gradients;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int count = 1;
		
		while (count <= T) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			gradients = new int[N][2];
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int score = Integer.parseInt(st.nextToken());
				int calorie = Integer.parseInt(st.nextToken());
				
				gradients[i][0] = score;
				gradients[i][1] = calorie;
			}
			
			max = 0;
			combination(0, 0, 0);
			
			System.out.printf("#%d %d%n", count, max);
			count++;
		}

	}
	
	static void combination(int scores, int calories, int index) {
		if (calories > L) {
			return;
		}
		
		if (scores > max) {
			max = scores;
		}
		
		for (int i=index; i<N; i++) {
			combination(scores + gradients[i][0], calories + gradients[i][1], i+1);	
		}
	}
}