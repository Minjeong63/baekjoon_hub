import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 음수가 있는데 짝수 개일 때 => 음수를 오름차순으로 정렬한 후 왼쪽부터 2개씩 묶어서 계산 음수가 있는데 홀수 개일 때 => 음수를 오름차순으로 정렬한 후 마지막 한개빼고 묶어서 계산 => 0이 있으면 남은
 * 하나의 음수랑 묶기 짝수는 그냥 오름차순 정렬한 후 오른쪽부터 2개씩 묶어서 계산
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> minus = new PriorityQueue<>();
        int zero = 0;
        int one = 0;
        Queue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 1) {
                one++;
            } else if (input > 0) {
                plus.add(input);
            } else if (input < 0) {
                minus.add(input);
            } else {
                zero++;
            }
        }

        int sum = 0;
        while (minus.size() > 1) {
            int num1 = minus.poll();
            int num2 = minus.poll();
            sum += num1 * num2;
        }
        if (minus.size() == 1) {
            if (zero == 0) {
                sum += minus.poll();
            }
        }

        while (plus.size() > 1) {
            int num1 = plus.poll();
            int num2 = plus.poll();
            sum += num1 * num2;
        }
        if (plus.size() == 1) {
            sum += plus.poll();
        }
        sum += one;
        System.out.println(sum);
    }
}