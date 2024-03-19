import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int[] board;
    static ArrayList<Integer> list;
    static boolean[] visited;
    // 해당 노드를 대상으로 호출한 함수가 종료되었는지 여부를 관리하는 배열
    static boolean[] finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }

        // 순서대로 사이클이 발생하는 지 확인
        list = new ArrayList<>();
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int element : list) {
            System.out.println(element);
        }

    }

    static void dfs(int n, int start) {
        if (!visited[board[n]]) {
            visited[board[n]] = true;
            dfs(board[n], start);
            visited[board[n]] = false;
        }

        if (board[n] == start) {
            list.add(start);
        }
    }

}