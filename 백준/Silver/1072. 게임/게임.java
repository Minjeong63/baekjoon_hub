import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int X = Integer.parseInt(input[0]);
        int Y = Integer.parseInt(input[1]);

        long winRate = (long) Math.floor((double) Y * 100 / X);

        int left = 1;
        int right = 1_000_000_000;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            long newRate = (long) Math.floor((double) (Y + mid) * 100 / (X + mid));

            if (newRate > winRate) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }
}