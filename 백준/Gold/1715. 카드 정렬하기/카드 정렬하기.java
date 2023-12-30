import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            priorityQueue.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while (priorityQueue.size() > 1) {
            int num1 = priorityQueue.poll();
            int num2 = priorityQueue.poll();
            int sum = num1 + num2;
            priorityQueue.add(sum);
            result += sum;
        }
        System.out.println(result);

    }
}