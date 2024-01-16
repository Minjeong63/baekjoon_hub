import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] visited;
    static ArrayList<Integer>[] graph;
    static boolean isBipartiteGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            isBipartiteGraph = true;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            visited = new int[V + 1];
            graph = new ArrayList[V + 1];

            for (int j = 1; j <= V; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }

            for (int j = 1; j <= V; j++) {
                if (isBipartiteGraph && visited[j] == 0) {
                    dfs(j, 1);
                }
            }

            if (isBipartiteGraph) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static void dfs(int n, int color) {
        if (!isBipartiteGraph) {
            return;
        }

        visited[n] = color;
        for (int num : graph[n]) {
            if (visited[num] == 0) {
                dfs(num, 3 - color);

            } else {
                if (visited[num] == color) {
                    isBipartiteGraph = false;
                    return;
                }
            }
        }
    }
}