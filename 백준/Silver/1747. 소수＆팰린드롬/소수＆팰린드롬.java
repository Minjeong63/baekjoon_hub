import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long result = 0;
        while (result == 0) {
            if (isPrime(N) && isPalindrome(N)) {
                result = N;
            }
            N++;
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

    static boolean isPalindrome(int N) {
        String num = String.valueOf(N);
        String reverseNum = "";
        for (int i = num.length() - 1; i >= 0; i--) {
            reverseNum += num.charAt(i) - '0';
        }

        if (num.equals(reverseNum)) {
            return true;
        }
        return false;
    }
}