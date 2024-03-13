import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (true) {
            if (i + 9 > input.length() - 1) {
                sb.append(input.substring(i) + "\n");
                break;
            }
            if (i + 9 <= input.length() - 1) {
                sb.append(input.substring(i, i + 10) + "\n");
                i += 10;
            }
        }
        System.out.println(sb);
    }
}