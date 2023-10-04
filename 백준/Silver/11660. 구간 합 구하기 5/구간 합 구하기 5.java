import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] S = new int[N+1][N+1];
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j=1; j<=N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken()) + S[i][j-1];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			

			int sum = 0;
			
			for (int x=x1; x<=x2; x++) {
				sum += S[x][y2] - S[x][y1-1];
			}
			sb.append(sum + "\n");
		}

		System.out.println(sb);
	}
}
