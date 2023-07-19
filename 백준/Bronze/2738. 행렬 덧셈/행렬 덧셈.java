import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] A = new int[N][M];
		int[][] B = new int[N][M];
		String[][] result = new String[N][M];
		for (int i=0; i<N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j=0; j<M; j++) {
				A[i][j] = Integer.parseInt(input[j]);
			}
		}
		for (int i=0; i<N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j=0; j<M; j++) {
				B[i][j] = Integer.parseInt(input[j]);
			}
		}
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				result[i][j] = "" + (A[i][j] + B[i][j]);
			}
			System.out.println(String.join(" ", result[i]));
		}
	}
}