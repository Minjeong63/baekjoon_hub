import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] input = new int[9][9];
		int max = Integer.MIN_VALUE;
		int[] pos = new int[2];
		for (int i=0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<9; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
				if (input[i][j] > max) {
					max = input[i][j];
					pos[0] = i+1;
					pos[1] = j+1;
				}
			}
		}
		System.out.println(max);
		System.out.println(pos[0] + " " + pos[1]);
	}
}