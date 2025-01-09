import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Integer>[] graph;
    static boolean[] dfsIsVisited;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int V = Integer.parseInt(st.nextToken()); // 탐색 시작 번호

        graph = new ArrayList[N + 1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        // 정점 번호가 작은 것을 먼저 방문하기 위해
        for (int i=1; i<=N; i++) {
            Collections.sort(graph[i]);
        }

        dfsIsVisited = new boolean[N + 1];
        dfs(V);
        result.append("\n");
        bfs(V);
        System.out.println(result);
    }

    static void dfs(int start) {
        result.append(start).append(" ");
        dfsIsVisited[start] = true;

        List<Integer> prevNodeList = graph[start];
        for (int i=0; i<graph[start].size(); i++) {
            if (!dfsIsVisited[prevNodeList.get(i)]) {
                dfs(prevNodeList.get(i));
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        boolean[] visited = new boolean[N + 1];

        while (!queue.isEmpty()) {
            int visitedNode = queue.poll();
            if (visited[visitedNode]) {
                continue;
            }

            result.append(visitedNode).append(" ");
            visited[visitedNode] = true;

            List<Integer> prevNodeList = graph[visitedNode];
            for (int i=0; i<graph[visitedNode].size(); i++) {
                if (!visited[prevNodeList.get(i)]) {
                    queue.add(prevNodeList.get(i));
                }
            }
        }
    }
}