import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] arr;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        backtracking(0);
        System.out.println(result);
    }

    static void backtracking(int depth) {
        if (depth == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;

            if (isPossible(depth)) {
                backtracking(depth + 1);
            }
        }
    }

    static boolean isPossible(int depth) {
        for (int i = 0; i < depth; i++) {
            if (arr[depth] == arr[i]) {
                return false;
            } else if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}