import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {

	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	
	static void perm(int idx, String element) {

		// 기저조건
		if (idx == M) {
			sb.append(element + "\n");
			return;
		}


		// 유도파트
		for (int i=1; i<=N; i++) {
			perm(idx+1, element + i + " ");
		}

	}


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		perm(0, "");
		
		System.out.println(sb.toString());
	}
}
