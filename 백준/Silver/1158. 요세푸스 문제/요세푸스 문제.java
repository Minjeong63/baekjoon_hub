import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i=1; i<=N; i++) {
			queue.add(i);
		}
		
		StringBuilder sb = new StringBuilder("<");
		while (!queue.isEmpty()) {
			for (int i=1; i<K; i++) {
				queue.add(queue.remove());
			}
			if (queue.size() != 1) {
				sb.append(queue.remove() + ", ");
			} else {
				sb.append(queue.remove());
			}
		}
		sb.append(">");
		
		System.out.println(sb);
		
	}

}
