import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Math.min(N, M);
        for (int i = 0; i < min / 2; i++) {
            for (int j = 0; j < R; j++) {
                int temp = arr[i][i];

                // 위 왼쪽에서 오른쪽(x값 고정)
                for (int k = i + 1; k < M - i; k++) {
                    arr[i][k - 1] = arr[i][k];
                }
                // 오른쪽 위에서 아래(y값 고정)
                for (int k = 1 + i; k < N - i; k++) {
                    arr[k - 1][M - 1 - i] = arr[k][M - 1 - i];
                }
                // 아래 오른쪽에서 왼쪽(x값 고정)
                for (int k = M - 1 - i; k >= i + 1; k--) {
                    arr[N - 1 - i][k] = arr[N - 1 - i][k - 1];
                }
                // 왼쪽 아래에서 위(y값 고정)
                for (int k = N - 1 - i; k >= 2 + i; k--) {
                    arr[k][i] = arr[k - 1][i];
                }
                arr[i + 1][i] = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}