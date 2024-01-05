import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static boolean isGraph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            visited = new int[V + 1];
            isGraph = true;

            graph = new ArrayList[V + 1];
            for (int k = 1; k <= V; k++) {
                graph[k] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                String[] input = br.readLine().split(" ");
                int u = Integer.parseInt(input[0]);
                int v = Integer.parseInt(input[1]);
                graph[u].add(v);
                graph[v].add(u);
            }

            for (int j = 1; j <= V; j++) {
                if (!isGraph) {
                    sb.append("NO").append("\n");
                    break;
                }
                if (visited[j] == 0) {
                    dfs(j, 1);
                }
            }
            if (isGraph) {
                sb.append("YES").append("\n");
            }
        }
        System.out.println(sb);
    }

    static void dfs(int n, int color) {
        if (!isGraph) {
            return;
        }
        visited[n] = color;

        for (int num : graph[n]) {
            // 방문하지 않은 경우
            if (visited[num] == 0) {
                if (color == 1) {
                    dfs(num, 2);
                } else {
                    dfs(num, 1);
                }
            }

            // 방문했는데 인접한 경우
            if (visited[num] == color) {
                isGraph = false;
                return;
            }
        }
    }
}