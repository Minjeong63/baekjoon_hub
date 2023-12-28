import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static boolean[] visited;
    static int[] distance;
    static ArrayList<Edge>[] A;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        distance = new int[N + 1];
        A = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j < input.length - 1; j += 2) {
                A[Integer.parseInt(input[0])].add(new Edge(Integer.parseInt(input[j]), Integer.parseInt(input[j + 1])));
            }
        }

        bfs(1);
        int max = 1;
        for (int i = 1; i <= N; i++) {
            if (distance[i] > distance[max]) {
                max = i;
            }
        }
        visited = new boolean[N + 1];
        distance = new int[N + 1];
        bfs(max);
        Arrays.sort(distance);
        System.out.println(distance[N]);

    }

    static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Edge edge : A[node]) {
                if (!visited[edge.e]) {
                    visited[edge.e] = true;
                    queue.add(edge.e);
                    distance[edge.e] = distance[node] + edge.value;
                }
            }
        }


    }

    static class Edge {
        int e;
        int value;

        public Edge(int e, int value) {
            this.e = e;
            this.value = value;
        }

    }
}