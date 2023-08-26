import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {

	static int N, M;
	static int[] permArr;
	static StringBuilder sb = new StringBuilder();
	
	
	static void perm(int idx) throws IOException {

		// 기저조건
		if (idx == M) {
			
			for (int i=0; i<permArr.length; i++) {
				sb.append(permArr[i] + " ");
			}
			
			sb.append("\n");
			return;
		}


		// 유도파트
		for (int i=1; i<=N; i++) {
			permArr[idx] = i;
			perm(idx+1);
		}

	}


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		permArr = new int[M];

		perm(0);
		
		System.out.println(sb.toString());
	}
}
