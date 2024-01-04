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

    static int K;
    static boolean[] visited;
    static List<Integer>[] city;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        city = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            city[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            city[A].add(B);
        }

        bfs(X);
        if (sb.toString().equals("")) {
            System.out.println(-1);
        } else {

            System.out.println(sb);
        }
    }

    static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;
        int distance = 0;

        while (!q.isEmpty()) {
            if (distance == K) {
                List<Integer> sortedList = new ArrayList<>(q);
                Collections.sort(sortedList);
                for (int el : sortedList) {
                    sb.append(el).append("\n");
                }
                return;
            }

            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int node = q.poll();

                for (int num : city[node]) {
                    if (!visited[num]) {
                        q.add(num);
                        visited[num] = true;
                    }
                }
            }
            distance++;
        }
    }
}