import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int min = Integer.MAX_VALUE;
	static boolean[][] chessBoard;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		chessBoard = new boolean[N][M];
		for (int i=0; i<N; i++) {
			String[] input = br.readLine().split("");
			
			for (int j=0; j<M; j++) {
				if (input[j].equals("W")) {
					chessBoard[i][j] = true;
				} else {
					chessBoard[i][j] = false;
				}
			}
		}
		
		for (int i=0; i<=N-8; i++) {
			for (int j=0; j<=M-8; j++) {
				board(i, j);
			}
		}
		System.out.println(min);

	}
	
	static void board(int x, int y) {
		boolean color = chessBoard[x][y];
		int changeNum = 0;
		
		
		for (int i=x; i<x+8; i++) {
			for (int j=y; j<y+8; j++) {
				if (color == chessBoard[i][j]) {
					color = !color;
				} else {
					changeNum++;
					color = !color;
				}
			}
			color = !color;
		}
		changeNum = Math.min(changeNum, 64 - changeNum);
		min = Math.min(min, changeNum);
	}
}