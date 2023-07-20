import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.Point;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static int[][] inputArr;
	static int earthworm;
	static int M;
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			earthworm = 0;
			
			inputArr = new int[M][N];
			for (int j=0; j<K; j++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st2.nextToken());
				int y = Integer.parseInt(st2.nextToken());
				inputArr[x][y] = 1;
			}
			
			visited = new boolean[M][N];
			for (int j=0; j<M; j++) {
				for (int k=0; k<N; k++) {
					if (!visited[j][k] && inputArr[j][k] == 1) {
						bfs(j, k);
					}
				}
			}
			sb.append(earthworm + "\n");
			
		}
		System.out.println(sb);
	}
	
	static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList();
		queue.offer(new Point(x, y));
		visited[x][y] = true;
		
		while (!queue.isEmpty()) {
			Point pollQueue = queue.poll();
			
			int[] dx = {-1, 0, 1, 0};
			int[] dy = {0, 1, 0, -1};
			
			for (int i=0; i<4; i++) {
				int deltaX = pollQueue.x + dx[i];
				int deltaY = pollQueue.y + dy[i];
				if (deltaX >= 0 && deltaX < M && deltaY >= 0 && deltaY < N && !visited[deltaX][deltaY] && inputArr[deltaX][deltaY] == 1) {
					visited[deltaX][deltaY] = true;
					queue.offer(new Point(deltaX, deltaY));
				}
				
			}
		}
		earthworm++;
	}
}
