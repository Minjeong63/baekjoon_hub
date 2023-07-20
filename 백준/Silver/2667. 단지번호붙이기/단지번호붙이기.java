import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.Point;

public class Main {
	static int N;
	static int[][] inputArr ;

	static boolean[][] visited;
	static int number = 0;
	static int[] allNumbers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		allNumbers = new int[N * N];
		inputArr = new int[N][N];
		visited = new boolean[N][N];



		for (int i=0; i<N; i++) {
			String[] input = br.readLine().split("");
			for (int j=0; j<N; j++) {
				inputArr[i][j] = Integer.parseInt(input[j]);
			}
		}

		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (inputArr[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					bfs(i, j);
				}
			}
		}
		System.out.println(number);
		Arrays.sort(allNumbers);
		for (int i=0; i<N*N; i++) {
			if (allNumbers[i]!= 0) {
				System.out.println(allNumbers[i]);
			}
		}
	}

	static void bfs(int x, int y) {
		int numberOfGroup = 1;

		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		Queue<Point> queue = new LinkedList();
		queue.offer(new Point(x, y));

		while (!queue.isEmpty()) {
			Point pollNode = queue.poll();
			for (int i=0; i<4; i++) {
				int deltaX = pollNode.x + dx[i];
				int deltaY = pollNode.y + dy[i];

				if ( deltaX >= 0 && deltaX < N && deltaY >= 0 && deltaY < N && inputArr[deltaX][deltaY] == 1 && !visited[deltaX][deltaY]) {
					visited[deltaX][deltaY] = true;
					queue.offer(new Point(deltaX, deltaY));
					numberOfGroup++;
				}
			}
		}
		number++;
		allNumbers[number-1] = numberOfGroup;
	}
}
