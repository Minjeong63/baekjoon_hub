import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int findNum = Integer.parseInt(br.readLine());

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] board = new int[N][N];

        int x = N / 2;
        int y = N / 2;
        int count = 1;
        board[x][y] = count;
        int i = 0;

        int squareN = N * N;
        while (count < squareN) {
            for (int j = 0; j <= i / 2; j++) {
                count++;

                x += dx[i % 4];
                y += dy[i % 4];
                board[x][y] = count;

                if (count == squareN) {
                    break;
                }
            }
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int el : row) {
                sb.append(el + " ");
            }
            sb.append("\n");
        }

        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
                if (board[j][k] == findNum) {
                    sb.append((j + 1) + " " + (k + 1));
                }
            }
        }

        System.out.println(sb);
    }
}