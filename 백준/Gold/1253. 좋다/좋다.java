import java.io.*;
import java.util.*;

/**
 * 1. 문제 분석
 * - 시간복잡도 :
 * - 입출력 : 수의 값 Ai의 범위가 10억까지 가능하여 int 사용 가능할 듯 
 * 
 * 
 * 2. 슈도 코드
 * N(수의 개수)
 * A(수 데이터 저장 배열)
 * 
 * for(N만큼 반복하기) {
 * 	A 배열에 데이터 저장하기
 * }
 * 
 * A 배열 정렬하기
 * 
 * for(k를 0부터 N까지 반복) {
 * 	변수 초기화하기(찾고자 하는 값 find, 포인터 i, 포인터 j)
 * 	while(i<j) {
 * 		if (A[i] + A[j] == find) {
 * 			두 포인터 i, j가 k가 아닐 때 결괏값에 반영 및 while 문 종료
 * 			두 포인터 i, j가 k가 맞을 때 포인터 변경 및 계속 수행하기
 * 		else if (A[i] + A[j] < 찾고자 하는 값) 포인터 i 증가
 *		else 포인터 j 감소
 *		}
 *	}
 * }
 * 좋은 수의 개수 출력하기
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N];

		for (int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		int cnt = 0;
		
		for (int k=0; k<N; k++) {
			int i = 0, j = N-1;
			
			while (i < j) {
				if (A[i] + A[j] == A[k]) {
					if (i != k && j != k) {
						cnt++;
						break;
						
					} else if (i == k) {
						i++;
						
					} else if (j == k){
						j--;
					}
					
				} else if (A[i] + A[j] < A[k]) {
					i++;
					
				} else {
					j--;
				}
			}
		}
		System.out.println(cnt);
		
	}

}
