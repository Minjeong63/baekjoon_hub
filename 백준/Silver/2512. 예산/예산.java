import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());

        int[] province = new int[N];
        int left = 0;
        int right = 0;
        for (int i = 0; i < N; i++) {
            int budget = Integer.parseInt(input[i]);
            province[i] = budget;
            right = Math.max(right, province[i]);
        }

        while (left <= right) {
            int sum = 0;

            int mid = (left + right) / 2;
            for (int i = 0; i < province.length; i++) {
                if (mid > province[i]) {
                    sum += province[i];
                } else {
                    sum += mid;
                }
            }

            if (sum <= M) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(right);
    }
}