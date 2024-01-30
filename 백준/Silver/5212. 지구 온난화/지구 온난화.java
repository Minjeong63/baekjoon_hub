import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        // 땅일 땐 true, 바다일 땐 false로 저장
        boolean[][] grounds = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            char[] mapLine = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (mapLine[j] == 'X') {
                    grounds[i][j] = true;
                }
            }
        }

        // 모든 섬을 포함하는 가장 작은 직사각형으로 출력하기 위해 x, y의 최대, 최솟값 저장
        int xMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE;
        int yMin = Integer.MAX_VALUE;
        int yMax = Integer.MIN_VALUE;

        // 50년 후 땅이면 true, 바다이면 false
        boolean[][] groundsAfter50 = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 현재 땅이면서 인접한 곳에 땅이 2개 이상일 때
                if (grounds[i][j]) {
                    int groundNum = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < R && ny < C && grounds[nx][ny]) {
                            groundNum++;
                        }
                    }
                    if (groundNum >= 2) {
                        groundsAfter50[i][j] = true;
                        xMin = Math.min(xMin, i);
                        xMax = Math.max(xMax, i);
                        yMin = Math.min(yMin, j);
                        yMax = Math.max(yMax, j);
                    }
                }
            }
        }

        // 50년 후 지도 출력
        StringBuilder sb = new StringBuilder();
        for (int i = xMin; i <= xMax; i++) {
            for (int j = yMin; j <= yMax; j++) {
                if (groundsAfter50[i][j]) {
                    sb.append("X");
                } else {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}