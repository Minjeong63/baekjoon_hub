import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 지름길 개수, 12이하인 양의 정수
        int N = Integer.parseInt(st.nextToken());
        // 고속도로 길이, 10,000보다 작거나 같은 자연수
        int D = Integer.parseInt(st.nextToken());

        // index 거리까지 최소로 운전한 거리를 저장하는 배열
        int[] dp = new int[D + 1];
        for (int i = 1; i <= D; i++) {
            dp[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int minLength = Integer.parseInt(st.nextToken());
            pq.add(new Node(start, end, minLength));
        }

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int start = node.start;
            int end = node.end;
            int minLength = node.shortcutLength;

            if (start > D || end > D) {
                continue;
            }

            if (dp[start] + minLength < dp[end]) {
                dp[end] = dp[start] + minLength;

                for (int j = end + 1; j <= D; j++) {
                    if (dp[end] + j - end < dp[j]) {
                        dp[j] = dp[end] + j - end;
                    }
                }
            }
        }
        System.out.println(dp[D]);
    }

    static class Node {
        int start;
        int end;
        int shortcutLength;

        Node(int start, int end, int shortcutLength) {
            this.start = start;
            this.end = end;
            this.shortcutLength = shortcutLength;
        }
    }
}