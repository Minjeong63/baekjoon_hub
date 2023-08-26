import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] inputArr, combArr;
	static StringBuilder sb = new StringBuilder();


	static void comb(int idx, int start) {

		// 기저조건
		if (idx == M) {

			for (int i=0; i<combArr.length; i++) {
				sb.append(combArr[i] + " ");
			}
			sb.append("\n");
			return;
		}


		// 유도파트
		for (int i=start; i<N; i++) {
			combArr[idx] = inputArr[i];
			comb(idx + 1, i+1);
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		inputArr = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i=0; i<N; i++) {
			inputArr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(inputArr);

		combArr = new int[M];
		comb(0, 0);

		System.out.println(sb.toString());
	}
}