import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 신맛과 쓴맛의 차이가 가장 작을 때를 구하기
public class Main {
    static int N;
    static int[] S;
    static int[] B;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // 신맛
        S = new int[N];
        // 쓴맛
        B = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 1, 0, 0);
        System.out.println(answer);
    }

    // 트리 깊이, 신맛의 합, 쓴맛의 합, 선택된 재료 개수
    static void DFS(int level, int s, int b, int selectedCount) {
        if (level == N) {
            if (selectedCount != 0 && Math.abs(s - b) < answer) {
                answer = Math.abs(s - b);
            }
            return;
        }
        // 재료를 선택했을 때
        DFS(level + 1, s * S[level], b + B[level], selectedCount + 1);
        // 재료를 선택하지 않았을 때
        DFS(level + 1, s, b, selectedCount);
    }
}