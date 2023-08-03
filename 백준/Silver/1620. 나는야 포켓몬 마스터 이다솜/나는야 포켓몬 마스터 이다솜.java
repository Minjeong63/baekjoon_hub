import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String[] list = new String[N+1];
		for (int i=1; i<=N; i++) {
			String input = br.readLine();
			map.put(input, i);
			list[i] = input;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=M; i++) {
			String input = br.readLine();
			if (map.containsKey(input)) {
				sb.append(map.get(input) + "\n");
			} else {
				sb.append(list[Integer.parseInt(input)] + "\n");
			}
		}
		System.out.println(sb);
		
	}
}