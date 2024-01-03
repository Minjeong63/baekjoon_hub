import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        long A = Long.valueOf(input[0]);
        long B = Long.valueOf(input[1]);
        long gcd = gcd(Math.min(A, B), Math.max(A, B));

        for (int i = 0; i < gcd; i++) {
            bw.write("1");
        }
        bw.flush();
        bw.close();
    }

    static long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}