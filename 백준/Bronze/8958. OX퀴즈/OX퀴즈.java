import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int sum = 0;
            int score = 0;
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < input.length; j++) {
                if (input[j] == 'O') {
                    score++;
                    sum += score;
                } else {
                    score = 0;
                }
            }
            System.out.println(sum);
        }
    }
}