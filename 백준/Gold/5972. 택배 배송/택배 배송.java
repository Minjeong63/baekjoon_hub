import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] map = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a].add(new Node(b, c));
            map[b].add(new Node(a, c));
        }

        int[] minDist = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            minDist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node el = pq.poll();

            if (visited[el.n]) {
                continue;
            }
            visited[el.n] = true;
            for (Node node : map[el.n]) {
                if (!visited[node.n]) {
                    if (minDist[node.n] > minDist[el.n] + node.dist) {
                        minDist[node.n] = minDist[el.n] + node.dist;
                    }
                    pq.add(new Node(node.n, minDist[node.n]));
                }
            }
        }
        System.out.println(minDist[N]);
    }

    static class Node implements Comparable<Node> {
        int n;
        int dist;

        Node(int n, int dist) {
            this.n = n;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.dist, node.dist);
        }
    }
}