import java.io.*;
import java.util.*;

public class Main {
	
	static int[] permArr;
	static boolean[] isSelectedArr;
	static int N, M;
	
	static void perm(int idx) {
		
		if (idx == M) {
            
			StringBuilder sb = new StringBuilder();
			
			for (int i=0; i<permArr.length; i++) {
				sb.append(permArr[i] + " ");
			}
			
			System.out.println(sb.toString());
            
			return;
		}
		
		for (int i=1; i<=N; i++) {
			if (!isSelectedArr[i]) {
				permArr[idx] = i;
				isSelectedArr[i] = true;
				perm(idx+1);
				isSelectedArr[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		permArr = new int[M];
		isSelectedArr = new boolean[N+1];
		
		perm(0);
		
	}

}
