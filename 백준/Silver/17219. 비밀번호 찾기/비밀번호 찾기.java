import java.io.*;
import java.util.*;

/**
 * 1. 문제 분석
 * - 시간복잡도 : 최악일 때 n^2 => 완탐으로 풀면 100초라서 시간초과
 * 
 * 
 * 
 * 2. 슈도 코드
 * 
 * 
 */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i=1; i<= N; i++) {
			String[] input = br.readLine().split(" ");
			map.put(input[0], input[1]);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=M; i++) {
			String index = br.readLine();
			sb.append(map.get(index) + "\n");
		}
		System.out.println(sb);

	}

}
