import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 다리 위에는 단지 w대의 트럭만 동시에 올라갈 수 있음
    // 다리의 길이는 w 단위길이이며, 각 트럭들은 하나의 단위시간에 하나의 단위길이만큼만 이동할 수 있음
    // 동시에 다리 위에 올라가 있는 트럭들의 무게의 합은 L보다 작거나 같아야 함

    // 트럭이 올라갈 수 있을 때 => 올라오려는 트럭과 현재 올라와있는 트럭의 하중의 합이 L보다 작거나 같으면서 다리 위에 올라온 트럭의 수 + 현재 트럭 수(1)가 w보다 작거나 같을 때
    // 전체 시간이 1초 지날 때 일어나는 일
    // => 다리 위에 있는 맨 앞 트럭의 시간이 w이면 다리에서 제
    // => 다리 위에 있는 트럭들의 시간이 1 추가
    // => 트럭이 올라갈 수 있는 조건을 만족한다면 1의 시간을 지닌 트럭이 다리 위로 올라감
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        // 트럭 무게 저장
        int[] truck = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck[i] = Integer.parseInt(st.nextToken());
        }

        // 최단 시간
        int time = 0;
        // 다리 위에 올라가 있는 트럭들의 무게의 합
        int weightOnBridge = 0;
        // 몇 번째 트럭까지 다리 위에 올라갔는 지
        int index = 0;
        // 다리 위에 올라간 트럭들의 정보를 저장하는 queue
        Queue<Node> q = new LinkedList<>();
        // 초기값
        q.add(new Node(truck[index], 1));
        time++;
        weightOnBridge += truck[index];
        index++;

        while (!q.isEmpty()) {
            // 다리 위 트럭 중 맨 앞 트럭의 시간이 w일 때 다리 위에서 제외
            if (q.peek().time == w) {
                weightOnBridge -= q.poll().truck;
            }
            // 다리 위 트럭들의 시간 +1
            for (Node node : q) {
                node.time++;
            }

            // 아래 조건을 만족하면 새 트럭 다리 위로 추가
            // 올라 오려는 트럭과 현재 올라와 있는 트럭의 하중의 합이 L보다 작거나 같으면서 다리 위에 올라온 트럭의 수 + 현재 트럭 수(1)가 w보다 작거나 같을 때
            if (index < n && weightOnBridge + truck[index] <= L && q.size() < w) {
                weightOnBridge += truck[index];
                q.add(new Node(truck[index], 1));
                index++;
            }
            time++;
        }
        System.out.println(time);
    }

    static class Node {
        int truck;
        int time;

        Node(int truck, int time) {
            this.truck = truck;
            this.time = time;
        }
    }
}