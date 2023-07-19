import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int K;
	static boolean[] visited = new boolean[100001];
	static int time = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs(N);
	}

	static void bfs(int n) {
		Queue<Integer> queue = new LinkedList();
		queue.offer(n);
		visited[n] = true;

		while(!queue.isEmpty()) {
			int qSize = queue.size();
			for (int i=0; i<qSize; i++) {
				int pollNode = queue.poll();
				
				if (pollNode == K) {
					System.out.println(time);
					return;
				}
				
				int[] dx = {pollNode - 1, pollNode + 1, pollNode * 2};
				for (int j=0; j<dx.length; j++) {
					if (dx[j] >= 0 && dx[j] <= 100000 && !visited[dx[j]] ) {
						queue.offer(dx[j]);
						visited[dx[j]] = true;
					}
				}
			}
			time++;


		}

	}
}
