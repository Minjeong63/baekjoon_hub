import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 1. 문제 분석
 * - 시간복잡도 : nLog(n) => 5백만Log(5백만) => 5백만 * 22 => 11억(2.6초를 넘어 불가능)
 * - 입출력 : 
 * 
 * 
 * 2. 슈도 코드
 * N(데이터 개수), L(최솟값을 구하는 범위)
 * Deque<Node> mydeque(데이터를 담을 덱 자료구조)
 * 
 * for(N만큼 반복) {
 * 	now(현재 데이터 값)
 * 	덱의 마지막 위치에서부터 now보다 큰 값은 덱에서 제거하기
 * 	덱의 마지막 위치에 now값 저장하기
 * 	덱의 1번째 위치에서부터 L의 범위를 벗어난 값을 덱에서 제거하기
 * 	덱의 1번째 값 출력하기
 * }
 * 
 * 덱에 저장할 노드 클래스 별도 생성하기
 * 노드 클래스에는 index(자신의 위치), value(자신의 값) 담기
 * 
 */
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		
		Deque<Node> mydeque = new LinkedList<>();
		
		for (int i=0; i<N; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			while (!mydeque.isEmpty() && mydeque.getLast().value >= now) {
				mydeque.removeLast();
			}
			
			mydeque.addLast(new Node(now, i));
			
			if (mydeque.getFirst().index <= (i - L)) {
				mydeque.removeFirst();
			}

			bw.write(mydeque.getFirst().value + " ");
		}
		bw.flush();
		bw.close();
	}
	
	static class Node {
		public int value;
		public int index;
		
		Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}

}
