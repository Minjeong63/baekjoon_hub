import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

        System.out.println(sb);
    }

    static void dfs(int num, int length) {
        if (length == N) {
            if (isPrime(num)) {
                System.out.println(num);
            }
            return;
        }

        for (int i = 1; i <= 9; i += 2) {
            if (isPrime(num * 10 + i)) {
                dfs(num * 10 + i, length + 1);
            }
        }
    }

    static boolean isPrime(int N) {
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }
}