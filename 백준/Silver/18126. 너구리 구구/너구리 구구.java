import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 입구에서 최대한 먼 방에 아이스크림을 숨겼을 때 그 방까지 이동하는 거리 구하기
public class Main {
    static int N;
    static long[][] road;
    static boolean[] visited;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        road = new long[N + 1][N + 1];
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            road[A][B] = C;
            road[B][A] = C;
        }

        visited = new boolean[N + 1];
        dfs(1, 0);
        System.out.println(answer);
    }

    static void dfs(int n, long dist) {
        if (answer < dist) {
            answer = dist;
        }
        visited[n] = true;

        for (int i = 1; i <= N; i++) {
            if (road[n][i] != 0 && !visited[i]) {
                dfs(i, dist + road[n][i]);
            }
        }
    }
}