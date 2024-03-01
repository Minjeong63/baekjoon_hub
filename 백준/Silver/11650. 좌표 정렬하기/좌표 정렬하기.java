import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] arags) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Position> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            pq.add(new Position(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        while (!pq.isEmpty()) {
            Position pos = pq.poll();
            System.out.println(pos.x + " " + pos.y);
        }
    }

    static class Position implements Comparable<Position> {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Position o) {
            if (x < o.x) {
                return -1;
            } else if (x == o.x) {
                if (y < o.y) {
                    return -1;
                }
            }
            return 1;
        }
    }
}