import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] timeTable = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            timeTable[i][0] = start;
            timeTable[i][1] = end;
        }

        Arrays.sort(timeTable, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        int result = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            if (timeTable[i][0] >= end) {
                end = timeTable[i][1];
                result++;
            }
        }

        System.out.println(result);
    }


}