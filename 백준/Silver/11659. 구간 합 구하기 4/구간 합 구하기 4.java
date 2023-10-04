import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] inputList = new int[N];
		st = new StringTokenizer(br.readLine());
		
		int[] sumList = new int[N];
		int sum = 0;
		for (int i=0; i<N; i++) {
			inputList[i] = Integer.parseInt(st.nextToken());
			sum += inputList[i];
			sumList[i] += sum;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int k=0; k<M; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			if (i == 1) {
				sb.append(sumList[j-1] + "\n");
			}
			else sb.append(sumList[j-1] - sumList[i-2] + "\n");
		}
		
		System.out.println(sb);
	}
}