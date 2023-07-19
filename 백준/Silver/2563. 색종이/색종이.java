import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[100][100];
		int result = 0;
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int j=x; j<x+10; j++) {
				for (int k=y; k<y+10; k++) {
					if (paper[j][k] == 0) {
						paper[j][k] = 1;
						result++;
					}
				}
			}
		}
		System.out.println(result);
	}
}