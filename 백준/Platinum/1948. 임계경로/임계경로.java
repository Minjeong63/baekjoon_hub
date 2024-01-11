import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Node>[] A = new ArrayList[n + 1];
        ArrayList<Node>[] reverseA = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<>();
            reverseA[i] = new ArrayList<>();
        }
        int[] indegree = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int time = Integer.parseInt(input[2]);
            A[start].add(new Node(end, time));
            reverseA[end].add(new Node(start, time));
            indegree[end]++;
        }

        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int[] result = new int[n + 1];
        while (!q.isEmpty()) {
            int now = q.poll();
            for (Node num : A[now]) {
                indegree[num.targetNode]--;
                result[num.targetNode] = Math.max(result[num.targetNode], result[now] + num.time);
                if (indegree[num.targetNode] == 0) {
                    q.add(num.targetNode);
                }
            }
        }

        boolean[] visited = new boolean[n + 1];
        int resultCount = 0;
        q.add(end);
        visited[end] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (Node node : reverseA[now]) {
                if (result[node.targetNode] + node.time == result[now]) {
                    resultCount++;
                    if (!visited[node.targetNode]) {
                        visited[node.targetNode] = true;
                        q.add(node.targetNode);
                    }
                }
            }
        }
        System.out.println(result[n]);
        System.out.println(resultCount);
    }

    static class Node {
        int targetNode;
        int time;

        public Node(int targetNode, int time) {
            this.targetNode = targetNode;
            this.time = time;
        }
    }
}