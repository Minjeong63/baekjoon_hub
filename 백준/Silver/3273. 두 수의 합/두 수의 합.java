import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[] inputArr = new boolean[2000000];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(br.readLine());

		for (int i=0; i<n; i++) {
			int key = Integer.parseInt(st.nextToken());
			inputArr[key] = true;
		}
		
		int cnt = 0;
		
		for (int i=1; i<x; i++) {
			if (inputArr[i] && inputArr[x-i]) {
				cnt++;
			}
		}
		System.out.println(cnt/2);
	}
}
