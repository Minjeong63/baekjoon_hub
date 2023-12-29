import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long start = 1;
        long end = k;
        long result = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for (int i = 1; i <= N; i++) {
                sum += Math.min(N, mid / i);
            }

            if (sum < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
                result = mid;
            }
        }
        System.out.println(result);
    }
}