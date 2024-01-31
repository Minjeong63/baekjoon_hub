import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 각각의 칸은 빈 칸 또는 벽
// 청소기는 바라보는 방향이 있으며, 0 => 북쪽, 1 => 동쪽, 2 => 남쪽, 3 => 서쪽
// 로봇 청소기의 작동 방법
// => 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸 청소함
// => 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
//      => 1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아감
//      => 2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춤
// => 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
//      => 1. 반시계 방향으로 회전(0 -> 3 -> 2 -> 1)
//      => 2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
//      => 3. 1번으로 돌아감
public class Main {
    static int N;
    static int M;
    static int[][] dxdy = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] room;
    static boolean[][] clean;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());
        room = new int[N][M];
        clean = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(x, y, direction);
        System.out.println(result);
    }

    static void dfs(int x, int y, int direction) {
        if (!clean[x][y]) {
            clean[x][y] = true;
            result++;
        }

        for (int i = 3 + direction; i >= direction; i--) {
            int nx = x + dxdy[i % 4][0];
            int ny = y + dxdy[i % 4][1];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && room[nx][ny] == 0 && !clean[nx][ny]) {
                dfs(nx, ny, i % 4);
                return;
            }
        }

        int nx = x + dxdy[(direction + 2) % 4][0];
        int ny = y + dxdy[(direction + 2) % 4][1];
        if (nx >= 0 && ny >= 0 && nx < N && ny < M && room[nx][ny] == 0) {
            dfs(nx, ny, direction);
        }

    }
}