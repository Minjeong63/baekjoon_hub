import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int result = 0;

        if (A + B > C * 2) {
            int min = Math.min(X, Y);
            result += 2 * C * min;
            X -= min;
            Y -= min;
        } else {
            int min = Math.min(X, Y);
            result += A * min;
            result += B * min;
            X -= min;
            Y -= min;
        }

        if (X != 0) {
            if (A >= C * 2) {
                result += 2 * C * X;
            } else {
                result += A * X;
            }
        }

        if (Y != 0) {
            if (B >= C * 2) {
                result += 2 * C * Y;
            } else {
                result += B * Y;
            }
        }
        System.out.println(result);


    }
}