import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 치즈가 모두 녹아 없어지는데 걸리는 정확한 시간 구하는 문제
// 치즈가 녹는 경우
// - 2변 이상이 실내 온도의 공기와 접촉한 것은 정확히 한시간만에 녹음
// - 치즈 내부에 있는 공간은 외부 공기와 접촉하지 않는 것으로 가정
// - 치즈가 녹아서 내부 공간으로 외부공기가 유입되면 치즈는 다시 녹을 수 있음
public class Main {

    static int N;
    static int M;
    static boolean[][] cheese;
    static boolean[][] isOuter;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int cheeseCount = 0;

        cheese = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                String input = st.nextToken();
                if (input.equals("1")) {
                    cheese[i][j] = true;
                    cheeseCount++;
                }
            }
        }

        int answer = 0;
        while (cheeseCount > 0) {
            isOuter = new boolean[N][M];
            checkOuterInner();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (cheese[i][j]) {
                        int outerCount = 0;
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                                continue;
                            }
                            if (!cheese[nx][ny] && isOuter[nx][ny]) {
                                outerCount++;
                            }
                        }
                        if (outerCount >= 2) {
                            cheese[i][j] = false;
                            cheeseCount--;
                        }
                    }
                }
            }
            answer++;
        }
        System.out.println(answer);
    }

    static void checkOuterInner() {
        boolean[][] visited = new boolean[N][M];
        Queue<Position> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            q.add(new Position(i, 0));
            visited[i][0] = true;
            isOuter[i][0] = true;
            q.add(new Position(i, M - 1));
            visited[i][M - 1] = true;
            isOuter[i][M - 1] = true;
        }
        for (int i = 0; i < M; i++) {
            q.add(new Position(0, i));
            visited[0][i] = true;
            isOuter[0][i] = true;
            q.add(new Position(N - 1, i));
            visited[N - 1][i] = true;
            isOuter[N - 1][i] = true;
        }

        while (!q.isEmpty()) {
            Position pos = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (!visited[nx][ny] && !cheese[nx][ny]) {
                    q.add(new Position(nx, ny));
                    visited[nx][ny] = true;
                    isOuter[nx][ny] = true;
                }
            }
        }
    }

    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}