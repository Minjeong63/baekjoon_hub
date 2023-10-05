import java.util.*;

/**
 * 1. 문제 분석
 * - 시간복잡도 : 최악일 때 1000만 * 1000만 시간이 걸리므로 완탐으로 풀 수 없음
 * 
 * 
 * 2. 슈도 코드
 * N을 입력받음(1000만보다 작은 자연수)
 * 
 * int[] naturalNum 에 N보다 작거나 같은 자연수를 차례대로 대입(for문)
 * 
 * left = 0, right = 0, sum = 0을 선언해줌
 * while (right < N) {
 * 	if (sum이 N보다 작으면) {
 * 		right 1개 증가
 * 	} else if (sum이 N이면) {
 * 		sum 1개 증가
 * 		right 1개 증가
 * 	} else (sum이 N보다 크면) {
 * 		left 1개 증가
 * 	}
 * }
 * 
 * sum 출력
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] naturalNum = new int[N];
		for (int i=0; i<N; i++) {
			naturalNum[i] = i+1;
		}

		int left = 0, right = 0, sum = naturalNum[right], cnt = 0;
		while (right < N) {
			if (sum < N) {
				right++;
				if (right < N) {
					sum += naturalNum[right];
				}
			} else if (sum == N) {
				cnt++;
				right++;
				if (right < N) {
					sum += naturalNum[right];
				}
			} else {
				sum -= naturalNum[left++];
			}
		}

		System.out.println(cnt);
	}
}
