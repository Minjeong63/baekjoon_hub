import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    static int[] trueList;
    static ArrayList<Integer>[] party;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int trueNum = Integer.parseInt(st.nextToken());
        int[] trueList = new int[trueNum];
        for (int i = 0; i < trueNum; i++) {
            trueList[i] = Integer.parseInt(st.nextToken());
        }

        party = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            party[i] = new ArrayList<>();
            int partySize = Integer.parseInt(st.nextToken());
            for (int j = 0; j < partySize; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int firstPerson = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                union(firstPerson, party[i].get(j));
            }
        }

        for (int i = 0; i < M; i++) {
            boolean isPossible = true;
            int cur = party[i].get(0);

            for (int j = 0; j < trueList.length; j++) {
                if (find(cur) == find(trueList[j])) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                result++;
            }
        }
        System.out.println(result);

    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return true;
        }
        return false;
    }
}