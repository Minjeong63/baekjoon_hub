import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int num = 0;
	static boolean visited[];
	static ArrayList<Integer>[] input;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int computer = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
	
		input = new ArrayList[computer+1];
		
		for (int i=0; i<computer+1; i++) {
			input[i] = new ArrayList<Integer>();
		}
		
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			input[a].add(b);
			input[b].add(a);
		}
		
		visited = new boolean[computer+1];
		bfs(1);
		System.out.println(num);
	}
	
	static void bfs(int n) {
		Queue<Integer> queue = new LinkedList();
		queue.offer(n);
		visited[n] = true;
		
		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (int i=0; i<input[node].size(); i++) {
				int pullNode = input[node].get(i);
				if (!visited[pullNode]) {
					num++;
					visited[pullNode] = true;
					queue.offer(pullNode);
				}
			}
		}
	}
}
