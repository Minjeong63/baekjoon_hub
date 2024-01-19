import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] city;
    static boolean[] visited;
    static ArrayList<Node> home;
    static ArrayList<Node> chicken;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];
        home = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cityVal = Integer.parseInt(st.nextToken());
                city[i][j] = cityVal;
                if (cityVal == 1) {
                    home.add(new Node(i, j));
                }
                if (cityVal == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }
        visited = new boolean[chicken.size()];
        backtracking(0, 0);
        System.out.println(result);
    }

    static void backtracking(int cnt, int index) {
        int sum = 0;
        if (cnt == M) {
            for (Node person : home) {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < chicken.size(); i++) {
                    if (visited[i]) {
                        Node node = chicken.get(i);
                        min = Math.min(min, Math.abs(node.x - person.x) + Math.abs(node.y - person.y));
                    }
                }
                sum += min;
                // 최솟값보다 중간 합이 더 클 때
                if (sum > result) {
                    break;
                }
            }
            result = Math.min(sum, result);
            return;
        }

        for (int i = index; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(cnt + 1, i + 1);
                visited[i] = false;
            }
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