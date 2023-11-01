import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int number = 1;

        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> stack = new LinkedList<>();
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(input[i]));
        }

        while (!queue.isEmpty()) {
            if (queue.peek() == number) {
                queue.remove();
                number++;
            } else if (!stack.isEmpty() && stack.peekLast() == number) {
                stack.removeLast();
                number++;
            } else {
                stack.addLast(queue.remove());
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peekLast() == number) {
                stack.removeLast();
                number++;
            } else {
                break;
            }
        }

        if (stack.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}