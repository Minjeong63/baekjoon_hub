import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static String[][] numberBoard = new String[5][5];
    static ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                numberBoard[i][j] = input[j];
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, numberBoard[i][j]);
            }
        }
        System.out.println(result.size());
    }

    static void dfs(int x, int y, String str) {
        if (str.length() == 6) {
            if (!result.contains(str)) {
                result.add(str);
            }
            return;
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int xVal = x + dx[i];
            int yVal = y + dy[i];
            if (xVal >= 0 && yVal >= 0 && xVal < 5 && yVal < 5) {
                dfs(xVal, yVal, str + numberBoard[xVal][yVal]);
            }
        }
    }
}