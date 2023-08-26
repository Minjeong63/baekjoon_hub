import java.io.*;
import java.util.*;

public class Main {
	
	static int[] combArr;
	static int N, M;
	
	
	static void comb(int idx, int start) {
		
		// 기저 조건
		if (idx == M) {
			
			StringBuilder sb = new StringBuilder();
			
			for (int i=0; i<combArr.length; i++) {
				sb.append(combArr[i] + " ");
			}
			
			System.out.println(sb.toString());
			
			return;

		}
		
		
		// 유도 파트
		for (int i=start; i<=N; i++) {
			
			combArr[idx] = i;
			comb(idx+1, i + 1);
			
		}
		
	}
	

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		combArr = new int[M];
		
		comb(0, 1);
		
	}

}
