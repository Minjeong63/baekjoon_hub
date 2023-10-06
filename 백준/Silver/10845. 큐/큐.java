import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Deque<Integer> deque = new LinkedList<>();

		for (int i=1; i<=N; i++) {
			String[] input = br.readLine().split(" ");

			switch (input[0]) {
				case "push":
					deque.offer(Integer.parseInt(input[1]));
					break;
					
				case "pop":
					if (deque.isEmpty()) sb.append("-1\n");
					else sb.append(deque.removeFirst() + "\n");
					break;
				
				case "size":
					sb.append(deque.size() + "\n");
					break;
					
				case "empty":
					if (deque.isEmpty()) sb.append("1\n");
					else sb.append("0\n");
					break;
					
				case "front":
					if (deque.isEmpty()) sb.append("-1\n");
					else sb.append(deque.getFirst() + "\n");
					break;
					
				case "back":
					if (deque.isEmpty()) sb.append("-1\n");
					else sb.append(deque.getLast() + "\n");
					break;
			}
		}
		System.out.println(sb);
	}

}
