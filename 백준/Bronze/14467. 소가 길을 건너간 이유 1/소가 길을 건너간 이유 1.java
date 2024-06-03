import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] cows = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        int answer = 0;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int cow = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            if (cows[cow] != -1 && cows[cow] != pos) {
                answer++;
            }
            cows[cow] = pos;
        }
        System.out.println(answer);
    }
}