import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<String> list = new ArrayList();
		Map<String, Integer> map = new HashMap();
		for (int i=0; i<N; i++) {
			String input = br.readLine();
			map.put(input, 1);
		}
		
		for (int i=0; i<M; i++) {
			String input = br.readLine();
			if (map.containsKey(input)) {
				list.add(input);
			}
		}
		Collections.sort(list);
		
		System.out.println(list.size());
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}