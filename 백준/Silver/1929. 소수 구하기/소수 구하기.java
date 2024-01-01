import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        StringBuilder sb = new StringBuilder();

        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                sb.append(i + "\n");
            }
        }
        System.out.println(sb);
    }

    static boolean isPrime(int N) {
        if (N == 1) {
            return false;
        }
        for (int i = 2; i * i <= N; i++) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }
}