import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] world = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            world[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int left = world[0];
        for (int i = 1; i < W - 1; i++) {
            int right = world[i + 1];
            for (int j = i + 1; j < W; j++) {
                if (world[j] > right) {
                    right = world[j];
                }
            }
            if (world[i] < left && world[i] < right) {
                sum += Math.min(left, right) - world[i];
            }
            if (world[i] > left) {
                left = world[i];
            }
        }
        System.out.println(sum);
    }
}