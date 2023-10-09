import java.io.*;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
	
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if (priorityQueue.size() == 0 && input == 0) {
				sb.append("0\n");
			} else if (input == 0) {
				sb.append(priorityQueue.poll() + "\n");
			} else {
				priorityQueue.add(input);
			}
		}
		System.out.println(sb);
	}

}
