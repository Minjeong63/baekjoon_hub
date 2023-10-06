import java.util.*;

/**
 * 1. 문제 분석
 * - 시간복잡도 : 완탐으로 생각해서 배열로 구현을 생각했을 때 
 * 최악의 복잡도가 n^2이라 2500억의 연산으로 2초를 넘겨버림
 * 따라서 다른 자료구조를 사용해야 함 => 큐
 * 
 * 2.  슈도 코드
 * N(카드의 개수)
 * Queue queue = new LinkedList();
 * queue에 카드 차례대로 넣기
 * 
 * if (queue.size() == 1) System.out.println(queue.poll());
 * 
 * while (!queue.isEmpty()) {
 * 	queue.poll()로 맨 위 카드 제거
 * 	if (queue.size() == 1) queue.poll() 출력; // 카드 하나 남으면 출력
 * 	else queue.offer(queue.poll()); // 카드가 1개 이상이면 맨 위 카드를 맨 밑에 넣기 
 * }
 *  
 * 
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i=1; i<=N; i++) {
			queue.offer(i);
		}
		
		// 카드가 하나일 때
		if (queue.size() == 1) System.out.println(queue.poll());

		// 카드가 한 개보다 많을 떄
		while (!queue.isEmpty()) {
			// 맨 위 카드 제거
			queue.poll();
			
			// 카드 하나 남으면 제거하며 출력
			if (queue.size() == 1) System.out.println(queue.poll());
			// 카드 한 개보다 많으면 맨 위 카드 맨 밑에 넣기
			else queue.offer(queue.poll());
		}
	}
}
