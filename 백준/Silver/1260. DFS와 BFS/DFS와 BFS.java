import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static boolean[] dfsVisited;
	public static boolean[] bfsVisited;
	public static ArrayList<Integer>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		dfsVisited = new boolean[N+1];
		bfsVisited = new boolean[N+1];
		
		graph = new ArrayList[N+1];
		for (int i=0; i<=N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for (int i=1; i<=M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(st2.nextToken());
			int value = Integer.parseInt(st2.nextToken());
			graph[key].add(value); 
			graph[value].add(key);
		}
		
		for (int i=0; i<=N; i++) {
			Collections.sort(graph[i]);
		}
		dfs(V);
		System.out.println();
		bfs(V);
	}
	
	public static void dfs(int N) {
		System.out.print(N + " ");
		dfsVisited[N] = true;
		
		for (int node : graph[N]) {
			if (!dfsVisited[node]) {
				dfs(node);
			}
		}
	}
	
	public static void bfs(int n) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(n);
		bfsVisited[n] = true;
		
		while (!queue.isEmpty()) {
			int nodeIndex = queue.poll();
			sb.append(nodeIndex + " ");
			
			for (int i=0; i<graph[nodeIndex].size(); i++) {
				int temp = graph[nodeIndex].get(i);
				
				if (!bfsVisited[temp]) {
					queue.offer(temp);
					bfsVisited[temp] = true;
				}
			}
		}
		System.out.print(sb.toString());
	}
	
	
}
