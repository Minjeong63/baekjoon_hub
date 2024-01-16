import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static ArrayList<Integer>[] list;
    static Queue<Node> q;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            list[a].add(b);
            list[b].add(a);
        }

        visited = new boolean[N + 1];
        q = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            Node poll = q.poll();
            sb.append(poll.prev + "\n");
        }
        System.out.println(sb);
    }

    static void dfs(int n) {
        visited[n] = true;
        for (int value : list[n]) {
            if (!visited[value]) {
                q.add(new Node(n, value));
                dfs(value);
            }
        }
    }

    static class Node {
        int prev;
        int value;

        Node(int prev, int value) {
            this.prev = prev;
            this.value = value;
        }
    }
}