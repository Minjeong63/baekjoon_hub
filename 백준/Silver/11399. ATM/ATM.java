import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(time);

        int min = 0;
        int prev = 0;
        for (int i = 0; i < N; i++) {
            prev += time[i];
            min += prev;

        }
        System.out.println(min);
    }
}