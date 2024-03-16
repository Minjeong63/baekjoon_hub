import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] king = new int[2];
        String input = st.nextToken();
        king[0] = input.charAt(0) - 'A' + 1;
        king[1] = input.charAt(1) - '0';

        int[] stone = new int[2];
        input = st.nextToken();
        stone[0] = input.charAt(0) - 'A' + 1;
        stone[1] = input.charAt(1) - '0';

        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            int[] position = new int[2];

            if (input.equals("R")) {
                position[0]++;
            } else if (input.equals("L")) {
                position[0]--;
            } else if (input.equals("B")) {
                position[1]--;
            } else if (input.equals("T")) {
                position[1]++;
            } else if (input.equals("RT")) {
                position[0]++;
                position[1]++;
            } else if (input.equals("LT")) {
                position[0]--;
                position[1]++;
            } else if (input.equals("RB")) {
                position[0]++;
                position[1]--;
            } else if (input.equals("LB")) {
                position[0]--;
                position[1]--;
            }

            int[] kingPos = {king[0] + position[0], king[1] + position[1]};
            if (kingPos[0] < 1 || kingPos[0] > 8 || kingPos[1] < 1 || kingPos[1] > 8) {
                continue;
            }

            int[] stonePos = {stone[0] + position[0], stone[1] + position[1]};
            if (kingPos[0] == stone[0] && kingPos[1] == stone[1]) {
                if (stonePos[0] < 1 || stonePos[0] > 8 || stonePos[1] < 1 || stonePos[1] > 8) {
                    continue;
                }
                stone[0] = stonePos[0];
                stone[1] = stonePos[1];
            }

            king[0] = kingPos[0];
            king[1] = kingPos[1];
        }
        System.out.println((char) (king[0] + 64) + "" + king[1]);
        System.out.println((char) (stone[0] + 64) + "" + stone[1]);
    }
}