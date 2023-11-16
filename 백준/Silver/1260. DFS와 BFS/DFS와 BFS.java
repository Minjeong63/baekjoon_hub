import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb1;
    static StringBuilder sb2;
    static boolean[] visited1;
    static boolean[] visited2;
    static ArrayList<Integer>[] node;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb1 = new StringBuilder();
        sb2 = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        visited1 = new boolean[N + 1];
        visited2 = new boolean[N + 1];

        node = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            node[num1].add(num2);
            node[num2].add(num1);
        }

        for (int i = 1; i < node.length; i++) {
            Collections.sort(node[i]);
        }

        dfs(V);
        bfs(V);

        System.out.println(sb1);
        System.out.println(sb2);

    }

    static void dfs(int V) {
        visited1[V] = true;
        sb1.append(V + " ");
        for (int i = 0; i < node[V].size(); i++) {
            if (!visited1[node[V].get(i)]) {
                dfs(node[V].get(i));
            }
        }
    }

    static void bfs(int V) {
        visited2[V] = true;
        sb2.append(V + " ");

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < node[V].size(); i++) {
            queue.add(node[V].get(i));
            visited2[node[V].get(i)] = true;
            sb2.append(node[V].get(i) + " ");
        }

        while (!queue.isEmpty()) {
            int queuePoll = queue.poll();

            for (int i = 0; i < node[queuePoll].size(); i++) {
                if (!visited2[node[queuePoll].get(i)]) {
                    queue.add(node[queuePoll].get(i));
                    visited2[node[queuePoll].get(i)] = true;
                    sb2.append(node[queuePoll].get(i) + " ");
                }
            }
        }
    }
}
