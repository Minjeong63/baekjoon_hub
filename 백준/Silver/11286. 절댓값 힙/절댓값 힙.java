import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=1; i<=N; i++) {
			int input = sc.nextInt();
			
			if (input != 0) {
				priorityQueue.add(new Node(Math.abs(input), input));
			} else {
				if (priorityQueue.size() == 0) {
					sb.append(0 + "\n");
				} else {
					Node output = priorityQueue.poll();
					sb.append(output.value + "\n");
				}
			}
		}
		System.out.println(sb);
		sc.close();
	}
	
	static class Node implements Comparable<Node> {
		public int size;
		public int value;
		
		Node(int size, int value) {
			this.size = size;
			this.value = value;
		}
		
		@Override
		public int compareTo(Node other) {
			if (this.size == other.size) {
				return Integer.compare(this.value, other.value);
			}
			return Integer.compare(this.size, other.size);
		}
	}

}
