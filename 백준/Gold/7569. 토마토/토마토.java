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
	static int[][][] inputArr;
	static boolean[][][] visited;
	static Queue<int[]> queue = new LinkedList();
	static int N;
	static int M;
	static int H;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[] dz = {1, 1, 1, 1, -1, -1, -1, -1, 0, 0, 0, 0};
	static int day = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		inputArr = new int[H][M][N];
		visited = new boolean[H][M][N];
		
		for (int i=0; i<H; i++) {
			for (int j=0; j<M; j++) {
				String[] input = br.readLine().split(" ");
				for (int k=0; k<N; k++) {
					inputArr[i][j][k] = Integer.parseInt(input[k]);
					
					if (inputArr[i][j][k] == 1 && !visited[i][j][k]) {
						queue.offer(new int[] {i, j, k});
						visited[i][j][k] = true;
					}
				}
			}
		}
		
		bfs();
		for (int i=0; i<H; i++) {
			for (int j=0; j<M; j++) {
				for (int k=0; k<N; k++) {
					if (inputArr[i][j][k] == 0) {
						day = -1;
					}
				}
			}
		}
		System.out.println(day);
	}
	
	static void bfs() {
		while (!queue.isEmpty()) {
			int qSize = queue.size();
			
			for (int i=0; i<qSize; i++) {
				int[] pollQueue = queue.poll();
				
				for (int j=0; j<4; j++) {
					int deltaX = pollQueue[1] + dx[j];
					int deltaY = pollQueue[2] + dy[j];
					
					if (deltaX >= 0 && deltaX < M && deltaY >= 0 && deltaY < N && inputArr[pollQueue[0]][deltaX][deltaY] == 0 && !visited[pollQueue[0]][deltaX][deltaY]) {
						inputArr[pollQueue[0]][deltaX][deltaY] = 1;
						visited[pollQueue[0]][deltaX][deltaY] = true;
						queue.offer(new int[] {pollQueue[0], deltaX, deltaY});
					}
				}
				
				int up = pollQueue[0] + 1;
				int down = pollQueue[0] - 1;
				
				if (up >= 0 && up < H && inputArr[up][pollQueue[1]][pollQueue[2]] == 0 && !visited[up][pollQueue[1]][pollQueue[2]]) {
					inputArr[up][pollQueue[1]][pollQueue[2]] = 1;
					visited[up][pollQueue[1]][pollQueue[2]] = true;
					queue.offer(new int[] {up, pollQueue[1], pollQueue[2]});			
				}
				
				if (down >= 0 && down < H && inputArr[down][pollQueue[1]][pollQueue[2]] == 0 && !visited[down][pollQueue[1]][pollQueue[2]]) {
					inputArr[down][pollQueue[1]][pollQueue[2]] = 1;
					visited[down][pollQueue[1]][pollQueue[2]] = true;
					queue.offer(new int[] {down, pollQueue[1], pollQueue[2]});			
				}
			}
			if (queue.size() != 0) {
				day++;				
			}
		}
	}
}

