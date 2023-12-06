import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] NArr = br.readLine().toCharArray();

        for (int i = 0; i < NArr.length - 1; i++) {
            int max = 0;
            int maxIndex = -1;
            for (int j = i; j < NArr.length; j++) {
                if (max < NArr[j]) {
                    max = NArr[j];
                    maxIndex = j;
                }
            }

            if (maxIndex == -1) {
                break;
            }
            if (NArr[i] == NArr[maxIndex]) {
                continue;
            }

            NArr[i] ^= NArr[maxIndex];
            NArr[maxIndex] ^= NArr[i];
            NArr[i] ^= NArr[maxIndex];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < NArr.length; i++) {
            sb.append(NArr[i]);
        }
        System.out.println(sb);


    }
}