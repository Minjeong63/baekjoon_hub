import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 1;
        int index = 1;
        while (true) {
            if (sum >= N) {
                System.out.println(index);
                break;
            }
            sum += 6 * index;
            index++;
        }
    }
}