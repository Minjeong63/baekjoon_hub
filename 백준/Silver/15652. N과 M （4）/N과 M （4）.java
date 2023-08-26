import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] permArr;
	static StringBuilder sb = new StringBuilder();
	
	static void nonDecreasinPermutation(int idx, int start) {
		
		// 기저조건
		if (idx == M) {
			
			for (int i=0; i<permArr.length; i++) {
				sb.append(permArr[i] + " ");
			}
			
			sb.append("\n");
			return;
		}
		
		// 유도파트
		for (int i=start; i<=N; i++) {
			permArr[idx] = i;
			nonDecreasinPermutation(idx+1, i);
		}
		
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		permArr = new int[M];
		nonDecreasinPermutation(0, 1);
		
		System.out.println(sb.toString());
	}

}
