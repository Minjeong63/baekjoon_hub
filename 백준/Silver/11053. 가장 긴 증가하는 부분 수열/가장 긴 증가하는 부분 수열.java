import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        // i번째 숫자를 마지막으로 하는 가장 긴 증가수열 길이 저장
        int[] dp = new int[N];
        // 각자 자기 자신을 가진 길이 1의 수열을 포함하기 때문
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] += max;
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}