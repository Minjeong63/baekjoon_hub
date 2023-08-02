import java.util.StringTokenizer;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int result = 0;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i=0; i<N; i++) {
			map.put(br.readLine(), 1);
		}
		
		for (int i=0; i<M; i++) {
			String key = br.readLine();
			if (map.containsKey(key)) {
				result++;
			}
		}
		System.out.println(result);
	}
}