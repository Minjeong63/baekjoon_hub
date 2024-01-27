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
        count[0] /= 2;
        count[1] /= 2;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("0") && count[0] > 0) {
                sb.append("0");
                count[0]--;
            }
            if (input[i].equals("1")) {
                if (count[1] > 0) {
                    count[1]--;
                } else if (count[1] == 0) {
                    sb.append("1");
                }
            }

        }
        System.out.println(sb);
    }
}