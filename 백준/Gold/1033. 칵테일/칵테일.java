import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<cNode>[] A;
    static boolean[] visited;
    static long[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        A = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }
        D = new long[N];
        long lcm = 1;
        visited = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            A[a].add(new cNode(b, p, q));
            A[b].add(new cNode(a, q, p));
            lcm *= (p * q / gcd(Math.min(p, q), Math.max(p, q)));
        }

        D[0] = lcm;
        DFS(0);

        long mgcd = D[0];
        for (int i = 1; i < N; i++) {
            mgcd = gcd(mgcd, D[i]);
        }
        for (int i = 0; i < N; i++) {
            System.out.print(D[i] / mgcd + " ");
        }
    }

    static long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    static void DFS(int N) {
        visited[N] = true;
        for (cNode i : A[N]) {
            int next = i.getB();
            if (!visited[next]) {
                D[next] = D[N] * i.getQ() / i.getP();
                DFS(next);
            }
        }
    }

    static class cNode {
        int b, p, q;

        public cNode(int b, int p, int q) {
            super();
            this.b = b;
            this.p = p;
            this.q = q;
        }

        public int getB() {
            return b;
        }

        public int getP() {
            return p;
        }

        public int getQ() {
            return q;
        }
    }
}