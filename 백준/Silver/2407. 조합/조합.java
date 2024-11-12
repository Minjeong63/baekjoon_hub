import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
	static int n;
	static int m;
	static BigInteger[][] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		memo = new BigInteger[n + 1][m + 1];
		
		BigInteger result = combination(n, m);
		System.out.println(result);

	}
	
	static BigInteger combination(int N, int M) {
		if (memo[N][M] != null) {
			return memo[N][M];
		}
		
		if (M == 0 || N == M) {
			return memo[N][M] = BigInteger.valueOf(1);
		}
		
		return memo[N][M] = combination(N-1, M-1).add(combination(N-1, M));
	}
}