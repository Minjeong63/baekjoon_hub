import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        Deque<Node> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            deque.addLast(new Node(i + 1, Integer.parseInt(input[i])));
        }

        int paperNumber = 1;
        while (!deque.isEmpty()) {
            Node explodedBalloon;

            if (paperNumber > 0) {
                for (int i = 0; i < paperNumber - 1; i++) {
                    deque.addLast(deque.removeFirst());
                }
                explodedBalloon = deque.removeFirst();
            } else {
                for (int i = 0; i > paperNumber + 1; i--) {
                    deque.addFirst(deque.removeLast());
                }
                explodedBalloon = deque.removeLast();
            }

            paperNumber = explodedBalloon.paperNumber;
            sb.append(explodedBalloon.index + " ");
        }
        System.out.println(sb);
    }

    static class Node {
        private int index;
        private int paperNumber;

        public Node(int index, int paperNumber) {
            this.index = index;
            this.paperNumber = paperNumber;
        }
    }
}
