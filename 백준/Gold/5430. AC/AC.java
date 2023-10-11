import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i=0; i<T; i++) {
			char[] p = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			String arrStr = br.readLine();

			// 배열 원소가 하나도 없을 때
			if (n == 0) {
				StringBuilder sb2 = new StringBuilder();
				
				// 함수 p에 D가 존재할 때
				for (int j=0; j<p.length; j++) {
					if (p[j] == 'D') {
						sb2.append("error");
						System.out.println(sb2);
						break;
					}
				}
				// 함수 p에 R만 존재할 때
				if (!sb2.toString().equals("error")) {
					sb2.append("[]");
					System.out.println(sb2);
				}
				
			// 배열 원소가 하나 이상일 때
			} else {
				StringBuilder sb = new StringBuilder();

				String[] arr = arrStr.substring(1, arrStr.length()-1).split(",");			

				// 순방향 : true, 역방향 : false
				boolean direction = true;
				Deque<Integer> deque = new ArrayDeque<>();

				for (int j=0; j<arr.length; j++) {
					deque.addLast(Integer.parseInt(arr[j]));

				}

				for (int j=0; j<p.length; j++) {
					// R이 나오면 direction을 바꿔줘서 방향을 바꿈
					if (p[j] == 'R') {
						direction = !direction;
						
					// D가 나왔을 때
					} else if (p[j] == 'D') {
						// deque에 원소가 하나도 없을 때
						if (deque.size() == 0) {
							sb.setLength(0);
							sb.append("error");
							break;
						// deque에 원소가 존재할 때, 방향에 따라 원소 제거
						} else {
							if (direction) {
								deque.removeFirst();
							} else {
								deque.removeLast();
							}
						}

					}
				}

				// error가 나지 않고 끝까지 잘 동작했을 때
				if (!sb.toString().equals("error")) {
					if (deque.size() == 0) {
						sb.append("[]");
					} else if (!direction) {
						Iterator<Integer> iterator = deque.descendingIterator();
//						deque = new ArrayDeque<>();
						sb.append("[");
						while (iterator.hasNext()) {
//							deque.addLast(iterator.next());
							sb.append(iterator.next() + ",");
						}
						sb.delete(sb.length()-1, sb.length());
						sb.append("]");
					} else if (direction) {
						Iterator<Integer> iterator = deque.iterator();
						sb.append("[");
						while (iterator.hasNext()) {
							sb.append(iterator.next() + ",");
						}
						sb.delete(sb.length()-1, sb.length());
						sb.append("]");
					}
					System.out.println(sb);
					
				// error 났을 때
				} else {
					System.out.println(sb);
				}
			}
		}
	}

}
