import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] color;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        color = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 마지막 집을 i번째 색깔로 칠했을 때 드는 비용의 최솟값
        int[][] dp = new int[N][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = color[0][i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        int i = 1;
        int j = 0;
        while (i < N) {
            for (int k = 0; k < 3; k++) {
                if (k != j && dp[i][k] > dp[i - 1][j] + color[i][k]) {
                    dp[i][k] = dp[i - 1][j] + color[i][k];
                }
            }
            j++;

            if (j == 3) {
                i++;
                j = 0;
            }
        }

        int min = dp[N - 1][0];
        for (int k = 1; k < 3; k++) {
            if (dp[N - 1][k] < min) {
                min = dp[N - 1][k];
            }
        }
        System.out.println(min);
    }
}