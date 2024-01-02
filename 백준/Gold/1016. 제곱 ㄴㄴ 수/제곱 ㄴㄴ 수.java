import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long min = Long.valueOf(input[0]);
        long max = Long.valueOf(input[1]);

        boolean[] check = new boolean[(int) (max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long startIndex = min / pow;
            if (min % pow != 0) {
                startIndex++;
            }

            for (long j = startIndex; pow * j <= max; j++) {
                check[(int) (j * pow - min)] = true;
            }
        }

        int result = 0;
        for (int i = 0; i < check.length; i++) {
            if (!check[i]) {
                result++;
            }
        }
        System.out.println(result);
    }
}