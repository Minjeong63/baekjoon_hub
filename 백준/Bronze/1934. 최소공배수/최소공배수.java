import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            int gcd = gcd(A, B);
            System.out.println(A * B / gcd);
        }
    }

    static int gcd(int a, int b) {
        int min = Math.max(a, b);
        int leftover = Math.min(a, b);
        while (leftover != 0) {
            int nextMin = leftover;
            leftover = min % leftover;
            min = nextMin;
        }
        return min;
    }
}