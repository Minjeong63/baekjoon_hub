import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.Point;

public class Main {
	static int[][] inputArr;
	static int N;
	static int M;
	
	static int result = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		inputArr = new int[N][M];

		for (int i=0; i<N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j=0; j<M; j++) {
				inputArr[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		dfs(0);
		System.out.println(result);

	}
	
	static void dfs(int wallCount) {
		if (wallCount == 3) {
			bfs();
			return;
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (inputArr[i][j] == 0) {
					inputArr[i][j] = 1;;
					dfs(wallCount+1);
					inputArr[i][j] = 0;
				}
			}
		}
	}

	static void bfs() {
		Queue<Point> queue = new LinkedList();
		
		int[][] duplInputArr = new int[N][M];
		
		for (int i=0; i<N; i++) {
			duplInputArr[i] = inputArr[i].clone();
			
			for (int j=0; j<M; j++) {
				if (duplInputArr[i][j] == 2) {
					queue.offer(new Point(i, j));
				}
			}
		}
		
		while (!queue.isEmpty()) {
			Point pollQueue = queue.poll();
			
			int[] dx = {-1, 0, 1, 0};
			int[] dy = {0, 1, 0, -1};
			for (int i=0; i<4; i++) {
				int deltaX = pollQueue.x + dx[i];
				int deltaY = pollQueue.y + dy[i];
				if (deltaX >= 0 && deltaX < N && deltaY >= 0 && deltaY < M && duplInputArr[deltaX][deltaY] == 0) {
					duplInputArr[deltaX][deltaY] = 2;
					queue.offer(new Point(deltaX, deltaY));
				}
			}
		}
		
		int safeArea = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (duplInputArr[i][j] == 0) {
					safeArea++;
				}
			}
		}
		result = Math.max(result, safeArea);
	}
}
