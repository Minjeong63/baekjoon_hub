import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static boolean[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        boolean[] init = new boolean[N];
        String[] input = br.readLine().split("");
        for (int i = 0; i < N; i++) {
            if (input[i].equals("1")) {
                init[i] = true;
            }
        }

        result = new boolean[N];
        input = br.readLine().split("");
        for (int i = 0; i < N; i++) {
            if (input[i].equals("1")) {
                result[i] = true;
            }
        }

        int firstSwitchPush = pushSwitch(true, init);
        int firstSwitchNotPush = pushSwitch(false, init);
        if (firstSwitchPush == -1 && firstSwitchNotPush == -1) {
            System.out.println(-1);
        } else if (firstSwitchPush != -1 && firstSwitchNotPush != -1) {
            System.out.println(Math.min(firstSwitchPush, firstSwitchNotPush));
        } else {
            System.out.println(Math.max(firstSwitchPush, firstSwitchNotPush));
        }

    }

    static int pushSwitch(boolean isPushed, boolean[] arr) {
        boolean[] init = Arrays.copyOf(arr, N);
        int min = 0;

        // 첫 번째 스위치를 눌렀을 때
        if (isPushed) {
            min++;
            init[0] = !init[0];
            init[1] = !init[1];
        }

        for (int i = 1; i < N - 1; i++) {
            if (init[i - 1] != result[i - 1]) {
                min++;
                init[i - 1] = !init[i - 1];
                init[i] = !init[i];
                init[i + 1] = !init[i + 1];
            }
        }

        if (init[N - 2] != result[N - 2]) {
            min++;
            init[N - 2] = !init[N - 2];
            init[N - 1] = !init[N - 1];
        }

        if (init[N - 1] != result[N - 1]) {
            min = -1;
        }

        return min;
    }


}