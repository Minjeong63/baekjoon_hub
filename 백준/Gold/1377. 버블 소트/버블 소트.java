import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] A = new Node[N];
        for (int i = 0; i < N; i++) {
            A[i] = new Node(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(A);

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (A[i].getIndex() - i > max) {
                max = A[i].getIndex() - i;
            }
        }
        System.out.println(max + 1);


    }

    static class Node implements Comparable<Node> {
        int value;
        int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

        int getValue() {
            return value;
        }

        int getIndex() {
            return index;
        }

        @Override
        public int compareTo(Node n) {
            return this.value - n.getValue();
        }
    }
}