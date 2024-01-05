import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] Sender = {0, 0, 1, 1, 2, 2};
    static int[] Receiver = {1, 2, 0, 2, 0, 1};
    static boolean[][] visited;
    static boolean[] answer;
    static int[] now;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        now = new int[input.length];
        now[0] = Integer.parseInt(input[0]);
        now[1] = Integer.parseInt(input[1]);
        now[2] = Integer.parseInt(input[2]);
        visited = new boolean[201][201];
        answer = new boolean[201];

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) {
                sb.append(i + " ");
            }
        }
        System.out.println(sb);
    }

    static void bfs() {
        Queue<AB> q = new LinkedList<>();
        q.add(new AB(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true;

        while (!q.isEmpty()) {
            AB node = q.poll();
            int A = node.A;
            int B = node.B;
            int C = now[2] - A - B;
            for (int k = 0; k < 6; k++) {
                int[] next = {A, B, C};
                next[Receiver[k]] += next[Sender[k]];
                next[Sender[k]] = 0;
                if (next[Receiver[k]] > now[Receiver[k]]) {
                    next[Sender[k]] = next[Receiver[k]] - now[Receiver[k]];
                    next[Receiver[k]] = now[Receiver[k]];
                }
                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    q.add(new AB(next[0], next[1]));
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }

    }

    static class AB {
        int A;
        int B;

        public AB(int A, int B) {
            this.A = A;
            this.B = B;
        }
    }
}