import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] inputArr;
	static boolean[] visited;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		visited = new boolean[N+1];
		inputArr = new ArrayList[N+1];
		for (int i=0; i<N+1; i++) {
			inputArr[i] = new ArrayList<Integer>();
		}

		for (int i=0; i<M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(st2.nextToken());
			int value = Integer.parseInt(st2.nextToken());
			inputArr[key].add(value);
			inputArr[value].add(key);
		}

		for (int i=1; i<=N; i++) {
			if (!visited[i]) {
				bfs(i);
			}
		}

		System.out.println(result);
	}
	
	static void bfs(int n) {
		Queue<Integer> queue = new LinkedList();
		queue.offer(n);
		visited[n] = true;
		
		while(!queue.isEmpty()) {
			int pollQueue = queue.poll();
			for (int i=0; i<inputArr[pollQueue].size(); i++) {
				if (!visited[inputArr[pollQueue].get(i)]) {
					visited[inputArr[pollQueue].get(i)] = true;
					queue.offer(inputArr[pollQueue].get(i));
				}
			}
		}
		result++;
	}
}
