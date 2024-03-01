import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] arags) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Position> pq = new PriorityQueue<>((a, b) -> a.x < b.x ? -1 : a.x == b.x ? a.y - b.y : 1);
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            pq.add(new Position(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Position pos = pq.poll();
            sb.append(pos.x + " " + pos.y + "\n");
        }
        System.out.println(sb);
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