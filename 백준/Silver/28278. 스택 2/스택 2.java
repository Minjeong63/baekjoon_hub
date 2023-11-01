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

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            switch (Integer.parseInt(input[0])) {
                case 1:
                    stack.addLast(Integer.parseInt(input[1]));
                    break;

                case 2:
                    if (stack.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(stack.removeLast());
                    }
                    sb.append("\n");
                    break;

                case 3:
                    sb.append(stack.size());
                    sb.append("\n");
                    break;

                case 4:
                    if (stack.isEmpty()) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;

                case 5:
                    if (stack.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(stack.peekLast());
                    }
                    sb.append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
