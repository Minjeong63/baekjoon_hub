import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T > 0) {
            T--;
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 국가의 수
            int N = Integer.parseInt(st.nextToken());
            // 비행기의 종류
            int M = Integer.parseInt(st.nextToken());

            for (int i = 0; i < M; i++) {
                br.readLine();
            }
            System.out.println(N - 1);
        }
    }
}