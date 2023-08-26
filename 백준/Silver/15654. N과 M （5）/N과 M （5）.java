import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] inputArr, permArr;
	static boolean[] isSelectedArr;
	static StringBuilder sb = new StringBuilder();
	
	
	static void perm(int idx) {
		
		if (idx == M) {
			
			for (int i=0; i<permArr.length; i++) {
				sb.append(permArr[i] + " ");
			}
			
			sb.append("\n");
			return;
		}
		
		for (int i=0; i<N; i++) {
			if (!isSelectedArr[inputArr[i]]) {
				isSelectedArr[inputArr[i]] = true;
				permArr[idx] = inputArr[i];
				perm(idx + 1);
				isSelectedArr[inputArr[i]] = false;
			}
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
		
		isSelectedArr = new boolean[inputArr[inputArr.length-1]+1];
		permArr = new int[M];
		perm(0);
		
		System.out.println(sb.toString());
	}
}