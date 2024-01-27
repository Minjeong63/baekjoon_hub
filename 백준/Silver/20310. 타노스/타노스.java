import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        int[] count = new int[2];
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("1")) {
                count[1]++;
            } else {
                count[0]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < count[i] / 2; j++) {
                sb.append(i);
            }
        }
        System.out.println(sb);
    }
}