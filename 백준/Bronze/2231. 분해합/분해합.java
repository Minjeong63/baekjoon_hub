import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		for (int i=1; i<=N; i++) {
			int sum = i;
			for (int j=1; j<=Integer.toString(i).length(); j++) {
				sum += Integer.toString(i).charAt(j-1) - '0';
			}
			if (sum == N) {
				result = i;
				break;
			}
		}
		if (result != 0) System.out.println(result);
		else System.out.println(0);
	}
}