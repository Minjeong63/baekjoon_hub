import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i=0; i<M; i++) {
			String[] input = br.readLine().split(" ");

			if (input[0].equals("add")) {
				if (!map.containsValue(Integer.parseInt(input[1]))) {
					map.put(Integer.parseInt(input[1]), Integer.parseInt(input[1]));

				}				
			} else if (input[0].equals("remove")) {
				if (map.containsValue(Integer.parseInt(input[1]))) {
					map.remove(Integer.parseInt(input[1]));

				}
			} else if (input[0].equals("check")) {
				if (map.containsValue(Integer.parseInt(input[1]))) {
					sb.append("1\n");

				} else {
					sb.append("0\n");

				}
			} else if (input[0].equals("toggle")) {
				if (map.containsValue(Integer.parseInt(input[1]))) {
					map.remove(Integer.parseInt(input[1]));

				} else {
					map.put(Integer.parseInt(input[1]), Integer.parseInt(input[1]));

				}
			} else if (input[0].equals("all")) {
				map.clear();

				for (int j=1; j<=20; j++) {
					map.put(j, j);
				}

			} else if (input[0].equals("empty")) {
				map.clear();

			}
		}
		System.out.println(sb);
	}

}
