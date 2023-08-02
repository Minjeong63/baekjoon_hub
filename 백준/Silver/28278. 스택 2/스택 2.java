import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		Stack<Integer> stack = new Stack<>();
		for (int i=0; i<N; i++) {
			String[] input = br.readLine().split(" ");
			int num = Integer.parseInt(input[0]);

			if (num == 1) {
				stack.push(Integer.parseInt(input[1]));
			} else if (num == 2) {
				if (!stack.empty()) {
					sb.append(stack.pop() + "\n");
				} else {
					sb.append(-1 + "\n");
				}

			} else if (num == 3) {
				sb.append(stack.size() + "\n");
			} else if (num == 4) {
				if (stack.empty()) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			} else if (num == 5) {
				if (!stack.empty()) {
					sb.append(stack.peek() + "\n");
				} else {
					sb.append(-1 + "\n");
				}
			}
		}
		System.out.println(sb);
	}
}