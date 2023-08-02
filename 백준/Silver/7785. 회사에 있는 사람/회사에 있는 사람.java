import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		HashSet<String> name = new HashSet<String>();
		for (int i=0; i<n; i++) {
			String[] input = br.readLine().split(" ");
			if (input[1].equals("enter")) {
				name.add(input[0]);
			} else if (input[1].equals("leave")) {
				name.remove(input[0]);
			}
		}
		
		ArrayList<String> nameList = new ArrayList(name);
		Collections.sort(nameList, Collections.reverseOrder());
		
		for (int i=0; i<nameList.size(); i++) {
			sb.append(nameList.get(i) + "\n");
		}
		
		System.out.println(sb);
	}
}