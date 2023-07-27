import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> inputArr = new ArrayList();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(br.readLine());

		for (int i=0; i<n; i++) {
			inputArr.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(inputArr);

		int i = 0, j = n-1;
		int pointNumber = 0;

		while (i < j) {
			if (inputArr.get(i) + inputArr.get(j) == x) {
				pointNumber++;
				i++;
				j--;
			} else if (inputArr.get(i) + inputArr.get(j) < x) {
				i++;
			} else {
				j--;
			}
		}
		System.out.println(pointNumber);
	}
}
