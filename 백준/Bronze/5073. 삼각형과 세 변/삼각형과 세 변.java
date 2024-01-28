import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            // 마지막 줄일 때 종료
            if (x == 0) {
                break;
            }

            // 삼각형의 조건을 만족하지 못할 떄
            int sum = x + y + z;
            int max = 0;
            max = Math.max(x, y);
            max = Math.max(max, z);
            sum -= max;
            if (sum <= max) {
                sb.append("Invalid\n");
            }
            // 세 변의 길이가 모두 다른 경우
            else if (x != y && y != z && z != x) {
                sb.append("Scalene\n");
            }
            // 세 변의 길이가 같을 때
            else if (x == y && y == z) {
                sb.append("Equilateral\n");
            }
            // 두변의 길이만 같을 때
            else {
                sb.append("Isosceles\n");
            }
        }
        System.out.println(sb);
    }
}