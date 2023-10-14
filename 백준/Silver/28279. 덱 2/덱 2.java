import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i=0; i<N; i++) {
			String[] input = br.readLine().split(" ");
			int num = Integer.parseInt(input[0]);
			
			if (num == 1) {
				deque.addFirst(Integer.parseInt(input[1]));
			} else if (num == 2) {
				deque.addLast(Integer.parseInt(input[1]));
			} else if (num == 3) {
				if (deque.size() != 0) {
					sb.append(deque.removeFirst() + "\n");
				} else {
					sb.append("-1\n");
				}
			} else if (num == 4) {
				if (deque.size() != 0) {
					sb.append(deque.removeLast() + "\n");
				} else {
					sb.append("-1\n");
				}
			} else if (num == 5) {
				sb.append(deque.size() + "\n");
			} else if (num == 6) {
				if (deque.size() == 0) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
			} else if (num == 7) {
				if (deque.size() != 0) {
					sb.append(deque.getFirst() + "\n");
				} else {
					sb.append("-1\n");
				}
			} else if (num == 8) {
				if (deque.size() != 0) {
					sb.append(deque.getLast() + "\n");
				} else {
					sb.append("-1\n");
				}
			}
		}
		System.out.println(sb);
	}

}
