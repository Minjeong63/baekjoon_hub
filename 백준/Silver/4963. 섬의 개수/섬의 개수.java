import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] inputArr;
	static boolean[][] visited;
	static int w;
	static int h;

	static int island = 0;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			inputArr = new int[h][w];
			visited = new boolean[h][w];

			if (w == 0 && h == 0) {
				return;
			}

			for (int i=0; i<h; i++) {
				String[] input = br.readLine().split(" ");
				for (int j=0; j<w; j++) {
					inputArr[i][j] = Integer.parseInt(input[j]);
				}
			}

			for (int i=0; i<h; i++) {
				for (int j=0; j<w; j++) {
					if (inputArr[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
					}
				}
			}
			System.out.println(island);
			island = 0;
		}


	}

	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] pollQueue = queue.poll();

			for (int i=0; i<8; i++) {
				int deltaX = pollQueue[0] + dx[i];
				int deltaY = pollQueue[1] + dy[i];

				if (deltaX >= 0 && deltaX < h && deltaY >= 0 && deltaY < w && inputArr[deltaX][deltaY] == 1 && !visited[deltaX][deltaY]) {
					queue.offer(new int[] {deltaX, deltaY});
					visited[deltaX][deltaY] = true;
				}
			}
		}
		island++;
	}
}
