import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.awt.Point;

public class Main {
	static int N;
	static int M;
	static boolean[][] visitedArr;
	static int[][] inputArr;
	static int distance = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		inputArr = new int[N+1][M+1];
		for (int i=0; i<N; i++) {
			String[] inputLine = br.readLine().split("");
			for (int j=0; j<M; j++) {
				inputArr[i+1][j+1] = Integer.parseInt(inputLine[j]);
			}
		}

		visitedArr = new boolean[N+1][M+1];
		
		bfs(1,1);
		System.out.println(distance);

	}

	static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<Point>();
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};

		queue.offer(new Point(x,y));
		visitedArr[x][y] = true;

		while (!queue.isEmpty()) {
			
			int qSize = queue.size();
			for (int k=0; k<qSize; k++) {
				Point p = queue.poll();
				if (p.x== N && p.y == M) {
					return;
				}

				for (int i=0; i<4; i++) {
					int changeX = p.x + dx[i];
					int changeY = p.y + dy[i];
					
					if (changeX >= 0 && changeX <= N && changeY >= 0 && changeY <= M && inputArr[changeX][changeY] == 1 && !visitedArr[changeX][changeY]) {
						queue.offer(new Point(changeX, changeY));
						visitedArr[changeX][changeY] = true;
					}
				}
			}
			distance++;
		}
	}
}
