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

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");

            switch(input[0]) {
                case "push":
                    queue.addLast(Integer.parseInt(input[1]));
                    break;

                case "pop":
                    if (queue.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(queue.removeFirst());
                    }
                    sb.append("\n");
                    break;

                case "size":
                    sb.append(queue.size());
                    sb.append("\n");
                    break;

                case "empty":
                    if (queue.isEmpty()) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;

                case "front":
                    if (queue.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(queue.peekFirst());
                    }
                    sb.append("\n");
                    break;

                case "back" :
                    if (queue.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(queue.peekLast());
                    }
                    sb.append("\n");
                    break;
            }
        }
        System.out.println(sb);

    }
}
