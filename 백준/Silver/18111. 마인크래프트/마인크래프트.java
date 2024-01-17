import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] heigh = new int[N][M];
        int minHeight = 258;
        int maxHeight = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int ground = Integer.parseInt(st.nextToken());
                heigh[i][j] = ground;
                minHeight = Math.min(minHeight, ground);
                maxHeight = Math.max(maxHeight, ground);
            }
            Arrays.sort(heigh[i]);
        }

        List<Integer> uniqueGround = new ArrayList<>();
        for (int i = minHeight; i <= maxHeight; i++) {
            uniqueGround.add(i);
        }

        int minTime = Integer.MAX_VALUE;
        int sameTimeMaxHeight = 0;
        for (int height : uniqueGround) {
            int sumTime = 0;
            int block = B;
            for (int i = N - 1; i >= 0; i--) {
                for (int j = M - 1; j >= 0; j--) {
                    int ground = heigh[i][j];
                    if (ground - height > 0) {
                        sumTime += 2 * (ground - height);
                        block += (ground - height);
                    } else if (ground - height < 0) {
                        sumTime += (height - ground);
                        block -= (height - ground);
                    }
                }
            }
            if (block >= 0) {
                if (minTime >= sumTime) {
                    minTime = sumTime;
                    sameTimeMaxHeight = height;
                }

            }
        }
        System.out.println(minTime + " " + sameTimeMaxHeight);
    }
}