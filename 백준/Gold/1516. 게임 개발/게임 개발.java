import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        int[] indegree = new int[N + 1];
        int[] selfBuild = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            selfBuild[i] = Integer.parseInt(input[0]);
            for (int j = 1; j < input.length - 1; j++) {
                int index = Integer.parseInt(input[j]);
                A[index].add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] result = new int[N + 1];
        while (!q.isEmpty()) {
            int poll = q.poll();
            for (int num : A[poll]) {
                indegree[num]--;
                result[num] = Math.max(result[num], result[poll] + selfBuild[poll]);
                if (indegree[num] == 0) {
                    q.add(num);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(result[i] + selfBuild[i]);
        }
    }
}