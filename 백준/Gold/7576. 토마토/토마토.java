import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.awt.Point;

public class Main {
	static int[][] inputArr;
	static int N;
	static int M;

	static Queue<Point> queue = new LinkedList();
	static int day = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		inputArr = new int[M][N];
		for (int i=0; i<M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				inputArr[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		for (int i=0; i<M; i++) {
			for (int j=0; j<N; j++) {
				if (inputArr[i][j] == 1) {
					queue.offer(new Point(i, j));
				}
			}
		}
		bfs();
		for (int i=0; i<M; i++) {
			for (int j=0; j<N; j++) {
				if (inputArr[i][j] == 0) {
					day = -1;
					break;
				}
			}
		}
		System.out.println(day);
	}

	static void bfs() {
		while(!queue.isEmpty()) {
			int qSize = queue.size();
			for (int i=0; i<qSize; i++) {
				Point pollQueue = queue.poll();

				int[] dx = {-1, 0, 1, 0};
				int[] dy = {0, 1, 0, -1};

				for (int j=0; j<4; j++) {
					int deltaX = pollQueue.x + dx[j];
					int deltaY = pollQueue.y + dy[j];

					if (deltaX >= 0 && deltaX < M && deltaY >= 0 && deltaY < N && inputArr[deltaX][deltaY] == 0 ) {
						inputArr[deltaX][deltaY] = 1;
						queue.offer(new Point(deltaX, deltaY));
					}
				}
			}
			if (queue.size() != 0) {
				day++;
			}
		}
	}
}

