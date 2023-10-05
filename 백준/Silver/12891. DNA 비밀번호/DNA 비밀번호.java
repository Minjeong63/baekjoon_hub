import java.io.*;
import java.util.*;

/**
 * 1. 문제 분석
 * - 시간 복잡도 : 
 * - 입출력 : 
 * 
 * 
 * 2. 슈도 코드
 * S(민호가 만든 DNA 길이), P(부분 문자열 길이) => 길이가 최대 100만이므로 int로 타입 지정
 * dnaString(민호가 만든 DNA 문자열) => String 타입 지정
 * dnaStringList => a, c, g, t가 각각 필요한 최소 개수를 알려줌(a부터 t까지 차례로 index 0~3)
 * windowList => 해당 슬라이딩 윈도우 안에 a, c, g, t가 몇개인지 확인 => dnaStringList의 개수에 충족되지 않으면 맨 앞 포인터를 떼서 맨 뒤 포인터 뒤에 붙이기
 * 
 * int left = 0, right = P-1, cnt = 0;
 * while (right != S && left != S) {
 * 	windowList의 모든 요소가 dnaStringList를 충족할 때만 cnt++
 * }
 * cnt 출력
 *  
 * 
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		char[] dnaString = br.readLine().toCharArray();

		int[] dnaStringList = new int[4];
		st = new StringTokenizer(br.readLine());

		for (int i=0; i<4; i++) {
			dnaStringList[i] = Integer.parseInt(st.nextToken());
		}


		int left = 0, right = P-1, cnt = 0;
		int[] windowList = new int[4];

		for (int i=left; i<=right; i++) {

			if (dnaString[i] == 'A') {
				windowList[0]++;
			} else if (dnaString[i] == 'C') {
				windowList[1]++;
			} else if (dnaString[i] == 'G') {
				windowList[2]++;
			} else {
				windowList[3]++;
			}
		}

		while (right != S) {
			if (windowList[0] >= dnaStringList[0] && windowList[1] >= dnaStringList[1] && windowList[2] >= dnaStringList[2] && windowList[3] >= dnaStringList[3]) {
				cnt++;
			} 

			if (dnaString[left] == 'A') {
				windowList[0]--;
			} else if (dnaString[left] == 'C') {
				windowList[1]--;
			} else if (dnaString[left] == 'G') {
				windowList[2]--;
			} else if (dnaString[left] == 'T') {
				windowList[3]--;
			}
			left++;

			right++;
			if (right == S) break;
			if (dnaString[right] == 'A') {
				windowList[0]++;
			} else if (dnaString[right] == 'C') {
				windowList[1]++;
			} else if (dnaString[right] == 'G') {
				windowList[2]++;
			} else if (dnaString[right] == 'T') {
				windowList[3]++;
			}

		}
		System.out.println(cnt);
	}

}
