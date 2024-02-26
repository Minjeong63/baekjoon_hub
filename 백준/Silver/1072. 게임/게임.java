import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 게임을 최소 몇 번 더 해야 형택이의 승률(Z)이 변하는 지 구하는 문제
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        // 게임 횟수
        int X = Integer.parseInt(input[0]);
        // 이긴 게임 횟수
        int Y = Integer.parseInt(input[1]);

        // 승률
        long Z = (long) Math.floor((double) Y * 100 / X);

        int left = 1;
        int right = 1_000_000_000;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            long newRate = (long) Math.floor((double) (Y + mid) * 100 / (X + mid));

            if (newRate > Z) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }
}