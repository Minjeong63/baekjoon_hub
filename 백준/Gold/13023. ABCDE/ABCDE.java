import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static boolean arrive = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];

        list = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 1);

            if (arrive) {
                break;
            }
        }

        if (arrive) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }


    }

    static void dfs(int num, int depth) {
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }

        if (visited[num]) {
            return;
        }

        visited[num] = true;
        for (int i = 0; i < list[num].size(); i++) {
            int next = list[num].get(i);
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }
        visited[num] = false;

    }
}