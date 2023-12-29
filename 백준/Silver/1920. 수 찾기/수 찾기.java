import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        String[] inputM = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            boolean find = false;
            int value = Integer.parseInt(inputM[i]);

            int start = 0;
            int end = N - 1;

            while (start <= end) {
                int midi = (start + end) / 2;
                int midV = A[midi];

                if (midV > value) {
                    end = midi - 1;
                } else if (midV < value) {
                    start = midi + 1;
                } else {
                    find = true;
                    break;
                }
            }

            if (find) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }

        }

        System.out.println(sb);
    }
}