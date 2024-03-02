import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Position> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            list.add(new Position(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (Position pos : list) {
            sb.append(pos.x + " " + pos.y);
            sb.append("\n");
        }
        System.out.println(sb);
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
            if (y < o.y) {
                return -1;
            } else if (y == o.y) {
                if (x < o.x) {
                    return -1;
                } else if (x == o.x) {
                    return 0;
                }
            }
            return 1;
        }
    }
}