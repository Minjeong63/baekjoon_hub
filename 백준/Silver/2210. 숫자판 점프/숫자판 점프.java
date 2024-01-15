import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] numberBoard = new int[5][5];
    static boolean[] visited = new boolean[1000000];
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                numberBoard[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, String.valueOf(numberBoard[i][j]));
            }
        }
        System.out.println(result);
    }

    static void dfs(int x, int y, String num) {
        if (num.length() == 6) {
            if (!visited[Integer.parseInt(num)]) {
                visited[Integer.parseInt(num)] = true;
                result++;
            }
            return;
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int xVal = x + dx[i];
            int yVal = y + dy[i];
            if (xVal >= 0 && yVal >= 0 && xVal < 5 && yVal < 5) {
                dfs(xVal, yVal, num + numberBoard[xVal][yVal]);
            }
        }
    }
}