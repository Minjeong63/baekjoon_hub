import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 지름길 개수, 12이하인 양의 정수
        int N = Integer.parseInt(st.nextToken());
        // 고속도로 길이, 10,000보다 작거나 같은 자연수
        int D = Integer.parseInt(st.nextToken());

        // index 거리까지 최소로 운전한 거리를 저장하는 배열
        int[] dp = new int[D + 1];
        for (int i = 1; i <= D; i++) {
            dp[i] = i;
        }

        int[][] shortcut = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            shortcut[i][0] = Integer.parseInt(st.nextToken());
            shortcut[i][1] = Integer.parseInt(st.nextToken());
            shortcut[i][2] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[D + 1];

        for (int i = 1; i <= D; i++) {
            result[i] = result[i - 1] + 1;
            for (int j = 0; j < N; j++) {
                if (shortcut[j][1] == i) {
                    if (shortcut[j][2] < shortcut[j][1] - shortcut[j][0]) {
                        result[i] = Math.min(result[shortcut[j][0]] + shortcut[j][2], result[i]);
                    }
                }
            }
        }
        System.out.println(result[D]);
    }
}