import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> result;
    static int n, k;
    static boolean[] visited;
    static int[] card;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        card = new int[n];
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(br.readLine());
        }
        visited = new boolean[n];
        result = new ArrayList<>();

        perm("", 0);
        System.out.println(result.size());
    }

    static void perm(String resultStr, int depth) {
        if (depth == k) {
            if (!result.contains(Integer.parseInt(resultStr))) {
                result.add(Integer.parseInt(resultStr));
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm(resultStr + card[i], depth + 1);
                visited[i] = false;
            }
        }
    }
}
