import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numList = new int[N];
        int[] F = new int[1_000_001];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(input[i]);
            numList[i] = num;
            F[num]++;
        }

        int[] result = new int[N];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && F[numList[stack.peekLast()]] < F[numList[i]]) {
                result[stack.pollLast()] = numList[i];
            }
            stack.add(i);
        }

        for (Integer index : stack) {
            result[index] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i] + " ");
        }
        System.out.println(sb);
    }
}