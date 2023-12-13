import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * D[i] : i를 1로 만드는 최소 연산 횟수
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] D = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            D[i] = D[i - 1] + 1;

            if (i % 2 == 0) {
                D[i] = Math.min(D[i], D[i / 2] + 1);
            }
            if (i % 3 == 0) {
                D[i] = Math.min(D[i], D[i / 3] + 1);
            }
        }
        System.out.println(D[N]);
    }
}