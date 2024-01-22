import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int s_x;
    static int s_y;
    static int[][] space; // 입력 받은 배열
    static int[][] dist;
    static int babySharkSize = 2;
    static int result = 0;
    static int minX, minY, minDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        space = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                space[i][j] = Integer.parseInt(input[j]);
                if (space[i][j] == 9) {
                    s_x = i;
                    s_y = j;
                    space[i][j] = 0;
                }
            }
        }

        int move = 0;
        int eat = 0;
        while (true) {
            dist = new int[N][N];
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            minDist = Integer.MAX_VALUE;

            bfs();

            if (minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
                eat++;
                space[minX][minY] = 0;
                s_x = minX;
                s_y = minY;
                move += dist[minX][minY];

                if (eat == babySharkSize) {
                    babySharkSize++;
                    eat = 0;
                }
            } else {
                break;
            }
        }
        System.out.println(move);
    }

    static Node bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s_x, s_y));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};
            for (int i = 0; i < 4; i++) {
                int xVal = node.x + dx[i];
                int yVal = node.y + dy[i];
                if (xVal >= 0 && yVal >= 0 && xVal < N && yVal < N && dist[xVal][yVal] == 0
                        && space[xVal][yVal] <= babySharkSize) {
                    dist[xVal][yVal] = dist[node.x][node.y] + 1;
                    if (space[xVal][yVal] != 0 && space[xVal][yVal] < babySharkSize) {
                        if (minDist > dist[xVal][yVal]) {
                            minX = xVal;
                            minY = yVal;
                            minDist = dist[xVal][yVal];
                        } else if (minDist == dist[xVal][yVal]) {
                            if (minX == xVal) {
                                if (minY > yVal) {
                                    minY = yVal;
                                }
                            } else if (minX > xVal) {
                                minX = xVal;
                                minY = yVal;
                            }
                        }
                    }
                    q.add(new Node(xVal, yVal));
                }
            }
        }

        if (q.isEmpty()) {
            return null;
        } else {
            return q.poll();
        }
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}