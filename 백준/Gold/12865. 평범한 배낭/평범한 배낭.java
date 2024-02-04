import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] item = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                item[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp[i번째 아이템][무게] = 가치합의 최댓값
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                // 이전 행의 값을 복사함
                dp[i][j] = dp[i - 1][j];
                // item의 무게가 j무게보다 작으면
                if (j - item[i][0] >= 0) {
                    // 이전 행의 복사한 값과 현재 값을 비교해서 큰 값을 저장
                    // 만약, 현재 무게가 현재 아이템 무게 + (현재 무게 - 현재 아이템 무게)보다 크다면 이 두개의 값을 비교해서 큰 값 저장
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - item[i][0]] + item[i][1]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}