import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * D[i] : i일까지 얻은 최대 이익
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            T[i] = Integer.parseInt(input[0]);
            P[i] = Integer.parseInt(input[1]);
        }

        int[] D = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            if (i + T[i] <= N + 1) {
                D[i + T[i]] = Math.max(D[i + T[i]], D[i] + P[i]);
            }
            D[i + 1] = Math.max(D[i + 1], D[i]);
        }
        System.out.println(D[N + 1]);
    }
}