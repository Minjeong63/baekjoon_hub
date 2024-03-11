import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push_front")) {
                deque.addFirst(Integer.parseInt(input[1]));
            } else if (input[0].equals("push_back")) {
                deque.addLast(Integer.parseInt(input[1]));
            } else if (input[0].equals("pop_front")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    int poll = deque.pollFirst();
                    System.out.println(poll);
                }
            } else if (input[0].equals("pop_back")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    int poll = deque.pollLast();
                    System.out.println(poll);
                }
            } else if (input[0].equals("size")) {
                System.out.println(deque.size());
            } else if (input[0].equals("empty")) {
                if (deque.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (input[0].equals("front")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    int poll = deque.peekFirst();
                    System.out.println(poll);
                }
            } else if (input[0].equals("back")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    int poll = deque.peekLast();
                    System.out.println(poll);
                }
            }
        }
    }
}