import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);
        long[] prime = new long[10000001];
        for (int i = 2; i < prime.length; i++) {
            prime[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i] == 0) {
                continue;
            }
            for (int j = i + i; j < prime.length; j += i) {
                prime[j] = 0;
            }
        }

        int result = 0;
        for (int i = 2; i < prime.length; i++) {
            if (prime[i] != 0) {
                long temp = prime[i];
                while ((double) prime[i] <= (double) B / (double) temp) {
                    if ((double) prime[i] >= (double) A / (double) temp) {
                        result++;
                    }
                    temp = temp * prime[i];
                }
            }
        }
        System.out.println(result);


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