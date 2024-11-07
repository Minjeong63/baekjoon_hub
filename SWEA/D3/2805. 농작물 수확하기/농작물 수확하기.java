import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int t = 1;
		
		while (t <= T) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] farm = new int[N][N];
			for (int i = 0; i < N; i++) {
				
				String[] line = br.readLine().split("");
				for (int j = 0; j < N; j++) {
					farm[i][j] = Integer.parseInt(line[j]);
				}
			}
			
			int total = 0;
			for (int i = 0; i <= N/2; i++) {
				for (int j = N/2 - i; j <= N/2 + i; j++) {
					total += farm[i][j];
				}
			}
			
			for (int i = N - 1; i > N/2; i--) {
				for (int j = N/2 - (N - 1 - i); j <= N/2 + (N - 1 - i); j++) {

					total += farm[i][j];
				}
			}
			
			System.out.printf("#%d %d%n", t, total);
			
			t++;
		}
	}

}