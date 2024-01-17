import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] student;
    static boolean[] visited;
    static boolean[] finished;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            student = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            for (int j = 1; j <= input.length; j++) {
                student[j] = Integer.parseInt(input[j - 1]);
            }

            count = 0;
            for (int j = 1; j <= n; j++) {
                dfs(j);
            }
            System.out.println(n - count);
        }
    }

    static void dfs(int n) {
        // 중복 방문 방지
        if (visited[n]) {
            return;
        }
        visited[n] = true;

        int next = student[n];
        if (!visited[next]) {
            dfs(next);

            // 사이클 계산
        } else {
            if (!finished[next]) {
                count++;
                for (int i = next; i != n; i = student[i]) {
                    count++;
                }
            }
        }
        finished[n] = true;
    }
}