import java.io.*;
import java.util.*;

/**
 * 1. 문제 분석
 * - 시간복잡도 : 최악일 때가 n^2 이므로 1,000,000,000,000 => 1조 시간이 필요하므로 시간초과로 완탐X,
 * - 투포인터도 사용 불가
 * - 입출력 : 
 * 
 * 2. 슈도 코드
 * N(수열의 크기) => 크기가 100만이므로 int 타입 지정
 * inputStack 생성 => 수열 원소가 저장됨
 * 
 * popstack을 하나 생성 => inputStack 원소가 뒤부터 차례대로 나와서 저장됨
 * 					 => 대신 저장될 때 inputStack에서 나온 원소가 
 * 					 => popStack의 pop 원소보다 크면 popStack 원소 하나 삭제한 후 삽입
 * inputStack에서 원소를 꺼낼 때마다 popStack의 pop 원소와 비교 후
 * popStack의 원소보다 클 경우에는 popStack의 pop 원소 제거 후 다음 원소랑 비교(while문)
 * 비교가 끝난 후에는 inputStack의 원소를 popStack에 다시 집어넣음
 * 
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Stack<Integer> inputStack = new Stack<Integer>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			inputStack.push(Integer.parseInt(st.nextToken()));
		}

		Stack<Integer> popStack = new Stack<Integer>();

		String[] result = new String[N];

		// 수열 원소들을 뒤에서부터 하나씩 꺼내 값 비교 후 result 배열에 NGE값을 저
		for (int i=0; i<N; i++) {
			// 수열 원소 뒤에서부터 꺼낸 값
			int element = inputStack.pop();

			if (popStack.isEmpty()) {
				result[N-i-1] = "-1";
				popStack.push(element);
				
			} else {
				if (popStack.peek() > element) {
					result[N-i-1] = popStack.peek().toString();
					popStack.push(element);
					
				} else {
					while (!popStack.isEmpty() && popStack.peek() <= element ) {
						popStack.pop();
					}
					
					if (popStack.isEmpty()) {
						result[N-i-1] = "-1";
						
					} else {
						result[N-i-1] = popStack.peek().toString();
						
					}
					popStack.push(element);
				}
			}
			
		}
		
		System.out.println(String.join(" ", result));
	}

}
