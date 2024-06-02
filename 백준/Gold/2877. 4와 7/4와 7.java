import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        K++;

        StringBuilder sb = new StringBuilder();

        while (K > 0) {
            sb.append(K % 2);
            K /= 2;
        }

        String binary = sb.reverse().substring(1).replaceAll("0", "4").replaceAll("1", "7");
        System.out.println(binary);
    }
}