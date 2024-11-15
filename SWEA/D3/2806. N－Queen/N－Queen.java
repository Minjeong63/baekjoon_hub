import java.io.*;
import java.util.*;

/**
 * 2024. 11. 15 금 / 오후 7시 52분
 * 
 * 요구사항 분석
 * 
 */
public class Solution {
	static int N;
	static int[] rowVisited;
	static boolean[] isColumnVisited;
	static int totalCount;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = 1;
		int T = Integer.parseInt(br.readLine());
		
		while (count <= T) {
			N = Integer.parseInt(br.readLine());
			totalCount = 0;
			
			rowVisited = new int[N];
			isColumnVisited = new boolean[N];
			for (int i=0; i<N; i++) {
				isColumnVisited[i] = true;
				rowVisited[0] = i;
				dfs(0);
				isColumnVisited[i] = false;
			}
			System.out.printf("#%d %d %n", count, totalCount);
			count++;
		}
	}
	
	static void dfs(int depth) {
		if (depth == N-1) {
			totalCount++;
			return;
		}
		
		for (int i=0; i<N; i++) {
			if (isPossible(depth + 1, i)) {
				isColumnVisited[i] = true;
				rowVisited[depth + 1] = i;
				dfs(depth + 1);
				isColumnVisited[i] = false;
			}
		}
	}
	
	static boolean isPossible(int x, int y) {
		// 세로 검증
		if (isColumnVisited[y]) {
			return false;
		}
		
		for (int i=1; i<=x; i++) {
			int rowIndex = x - i;
			int columnIndex = y - i;
			if (rowIndex < 0 || columnIndex < 0) {
				continue;
			}
			
			// 대각선 검증
			if (rowVisited[rowIndex] == columnIndex) {
				return false;
			}
		}
		
		for (int i=1; i<=x; i++) {
			int rowIndex = x - i;
			int columnIndex = y + i;
			if (rowIndex < 0 || columnIndex >= N) {
				continue;
			}
			
			// 대각선 검증
			if (rowVisited[rowIndex] == columnIndex) {
				return false;
			}
			
		}
		return true;
	}
}
