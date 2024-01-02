import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] prime = new int[10_000_001];
        for (int i = 2; i < prime.length; i++) {
            prime[i] = i;
        }

        for (int i = 2; i * i < prime.length; i++) {
            if (prime[i] == 0) {
                continue;
            }
            for (int j = i + i; j < prime.length; j += i) {
                prime[j] = 0;
            }
        }

        for (int i = N; i < prime.length; i++) {
            if (prime[i] != 0 && isPalindrome(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    static boolean isPalindrome(int N) {
        char[] num = String.valueOf(N).toCharArray();
        int start = 0;
        int end = num.length - 1;

        while (start <= end) {
            if (num[start] != num[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}