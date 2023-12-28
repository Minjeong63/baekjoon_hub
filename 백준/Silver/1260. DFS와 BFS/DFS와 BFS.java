import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visitedDfs;
    static boolean[] visitedBfs;
    static ArrayList<Integer>[] list;
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sbDfs = new StringBuilder();
    static StringBuilder sbBfs = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visitedDfs = new boolean[N + 1];
        visitedBfs = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }

        dfs(V);

        queue.add(V);
        visitedBfs[V] = true;
        bfs(V);

        System.out.println(sbDfs);
        System.out.println(sbBfs);
    }

    static void dfs(int n) {
        visitedDfs[n] = true;
        sbDfs.append(n + " ");

        for (int element : list[n]) {
            if (!visitedDfs[element]) {
                dfs(element);
            }
        }
    }

    static void bfs(int n) {
        while (!queue.isEmpty()) {
            int node = queue.poll();
            sbBfs.append(node + " ");

            for (int element : list[node]) {
                if (!visitedBfs[element]) {
                    queue.add(element);
                    visitedBfs[element] = true;
                }
            }
        }
    }
}