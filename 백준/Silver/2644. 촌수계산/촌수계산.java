import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int b;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        b = Integer.parseInt(input[1]);
        int m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            String[] relation = br.readLine().split(" ");
            int x = Integer.parseInt(relation[0]);
            int y = Integer.parseInt(relation[1]);
            list[x].add(y);
            list[y].add(x);
        }
        dfs(a, 0);
        System.out.println(result);
    }

    static void dfs(int n, int step) {
        if (n == b) {
            result = step;
            return;
        }
        if (visited[n]) {
            return;
        }
        visited[n] = true;

        for (int num : list[n]) {
            dfs(num, step + 1);
        }
    }
}