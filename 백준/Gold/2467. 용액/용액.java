import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] solution = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];
        while (left < right) {
            int sum = solution[left] + solution[right];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                answer[0] = solution[left];
                answer[1] = solution[right];
            }

            if (sum >= 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}