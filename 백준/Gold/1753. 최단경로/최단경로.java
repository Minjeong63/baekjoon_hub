import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int V;
    static ArrayList<Node>[] A;
    static boolean[] visited;
    static int[] minDistance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        A = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            A[u].add(new Node(v, w));
        }

        minDistance = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            minDistance[i] = Integer.MAX_VALUE;
        }

        visited = new boolean[V + 1];

        dijkstra(new Node(start, 0));

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                sb.append("INF").append("\n");
            } else {
                sb.append(minDistance[i]).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void dijkstra(Node n) {
        minDistance[n.next] = 0;
        Queue<Node> q = new PriorityQueue<>();
        q.add(n);
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (visited[now.next]) {
                continue;
            }
            visited[now.next] = true;
            for (Node node : A[now.next]) {
                if (minDistance[node.next] > minDistance[now.next] + node.value) {
                    minDistance[node.next] = minDistance[now.next] + node.value;
                    q.add(new Node(node.next, minDistance[node.next]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int next;
        int value;

        public Node(int next, int value) {
            this.next = next;
            this.value = value;
        }

        public int compareTo(Node n) {
            if (this.value > n.value) {
                return 1;
            } else {
                return -1;
            }
        }
    }


}