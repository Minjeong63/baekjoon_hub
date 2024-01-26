import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        char[] list = br.readLine().toCharArray();

        int maxPerson = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == 'P') {
                for (int j = Math.max(0, i - K); j <= Math.min(N - 1, i + K); j++) {
                    if (list[j] == 'H') {
                        list[j] = 'X';
                        maxPerson++;
                        break;
                    }
                }
            }
        }
        System.out.println(maxPerson);
    }
}