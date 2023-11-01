import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < K; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input != 0) {
                deque.addLast(input);
            } else {
                deque.removeLast();
            }
        }

        int sum = 0;
        while (!deque.isEmpty()) {
            sum += deque.removeLast();
        }
        System.out.println(sum);

    }
}