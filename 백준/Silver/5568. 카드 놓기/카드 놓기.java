import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] card = new int[n];
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(br.readLine());
        }

        result = new ArrayList<>();
        if (k == 2) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    int[] arr = {card[i], card[j]};
                    int[] output = new int[k];
                    boolean[] visited = new boolean[k];

                    perm(arr, output, visited, 0, k);
                }
            }
        }

        if (k == 3) {
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    for (int l = j + 1; l < n; l++) {
                        int[] arr = {card[i], card[j], card[l]};
                        int[] output = new int[k];
                        boolean[] visited = new boolean[k];

                        perm(arr, output, visited, 0, k);
                    }
                }
            }
        }

        if (k == 4) {
            for (int i = 0; i < n - 3; i++) {
                for (int j = i + 1; j < n - 2; j++) {
                    for (int l = j + 1; l < n - 1; l++) {
                        for (int m = l + 1; m < n; m++) {
                            int[] arr = {card[i], card[j], card[l], card[m]};
                            int[] output = new int[k];
                            boolean[] visited = new boolean[k];

                            perm(arr, output, visited, 0, k);
                        }
                    }
                }
            }
        }
        System.out.println(result.size());
    }

    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n) {
        if (depth == n) {
            String orderNumber = "";
            for (int i = 0; i < output.length; i++) {
                orderNumber += output[i];
            }
            if (!result.contains(Integer.parseInt(orderNumber))) {
                result.add(Integer.parseInt(orderNumber));
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n);
                visited[i] = false;
            }
        }
    }
}
