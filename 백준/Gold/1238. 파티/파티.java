import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] list;
    static ArrayList<Node>[] reverseList;
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        reverseList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, t));
            reverseList[b].add(new Node(a, t));
        }

        visited = new boolean[N + 1];
        int[] reverseMinDist = dijkstra(list, N, X);
        visited = new boolean[N + 1];
        int[] minDist = dijkstra(reverseList, N, X);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(reverseMinDist[i] + minDist[i], max);
        }
        System.out.println(max);

    }

    static int[] dijkstra(ArrayList<Node>[] list, int N, int n) {
        int[] dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (i != n) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(n, 0));
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (visited[now.next]) {
                continue;
            }
            visited[now.next] = true;
            for (Node node : list[now.next]) {
                int next = node.next;
                if (dist[next] > dist[now.next] + node.value) {
                    dist[next] = dist[now.next] + node.value;
                    q.add(new Node(next, dist[next]));
                }
            }
        }
        return dist;
    }

    static class Node implements Comparable<Node> {
        int next;
        int value;

        Node(int next, int value) {
            this.next = next;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            if (this.value - o.value > 0) {
                return 1;
            }
            return -1;
        }
    }
}