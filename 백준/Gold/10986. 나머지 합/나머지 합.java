import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		long[] S = new long[N+1];
		for (int i=1; i<=N; i++) {
			S[i] = Long.parseLong(st.nextToken()) + S[i-1];
		}

		long num = 0;

		int[] remainderList = new int[M];
		for (int i=1; i<=N; i++) {
			int remainder = (int) (S[i] % M);

			if (remainder == 0) num++;
			remainderList[remainder]++;
		}

		for (int i=0; i<M; i++) {
			if (remainderList[i] != 0) 
				num += (long)remainderList[i] * (long)(remainderList[i]-1) / 2;
		}
		System.out.println(num);
	}
}

