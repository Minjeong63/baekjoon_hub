import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split("");

            boolean VPS = true;
            Deque<String> stack = new ArrayDeque<>();
            for (int j = 0; j < input.length; j++) {
                if (input[j].equals("(")) {
                    stack.addLast(input[j]);
                } else {
                    if (!stack.isEmpty()) {
                        stack.removeLast();
                    } else {
                        VPS = false;
                        break;
                    }
                }
            }

            if (VPS && !stack.isEmpty()) {
                VPS = false;
            }

            if (VPS) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
