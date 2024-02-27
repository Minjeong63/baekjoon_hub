import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[] cnt = new int[100_001];

        int left = 0;
        int right = 0;
        cnt[a[right]]++;

        int answer = 0;
        while (right < N) {
            if (cnt[a[right]] <= K) {
                answer = Math.max(answer, right - left + 1);
                right++;
                if (right < N) {
                    cnt[a[right]]++;
                }
            } else {
                cnt[a[left]]--;
                left++;
            }
        }
        System.out.println(answer);
    }
}