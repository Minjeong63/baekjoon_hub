import java.util.*;
import java.io.*;

/**
 * 1. 문제 분석
 * - 시간 복잡도 : 최악일 때 2억2천500 2초정도 걸려서 애매함
 * 
 * 
 * 2. 슈도 코드
 * N(재료 개수 <=15,000),M(1000만) 선언
 * 크기가 N인 int[] gradients에 차례대로 재료 저장
 * int cnt 선언(만들 수 있는 갑옷 수)
 *
 * // 이중 for문으로 구현했을 때
 * for (i는 0부터 N-2까지) {
 * 	for (j는 i+1부터 N-1까지) {
 * 		if (gradients[i] + gradients[j]가 M인지) {
 * 			cnt 1개 증가
 * 		}
 * 	}
 * }
 * cnt 출력
 * 
 * // 투포인터로 구현했을 때
 * gradients 오름차순대로 정렬
 * left = 0, right = N-1, sum = gradients[left] + gradients[right]
 * while (left != right) {
 * 	if (sum == M) {
 * 		cnt++;
 * 		sum -= gradients[right]
 * 		right--;
 * 		sum += gradients[right]
 * 	} else if (sum > M) {
 * 		sum -= gradients[right]
 * 		right--;
 * 		sum += gradients[right]
 * 	} else {
 * 		sum -= gradients[left]
 * 		left++;
 * 		sum += gradients[left]
 * 	}
 * }
 * cnt 출력
 */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] gradients = new int[N];
		for (int i=0; i<N; i++) {
			gradients[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(gradients);

		int cnt = 0;
		int left = 0, right = N-1, sum = gradients[left] + gradients[right];
		while (left != right) {
			if (sum == M) {
				cnt++;
				sum -= gradients[right];
				right--;
				sum += gradients[right];
			} else if (sum > M) {
				sum -= gradients[right];
				right--;
				sum += gradients[right];
			} else {
				sum -= gradients[left];
				left++;
				sum += gradients[left];
			}
		}
		System.out.println(cnt);
	}
}
