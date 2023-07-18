import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 1;
		int i = 666;
		while (count != N) {
			i++;
			if (String.valueOf(i).contains("666")) {
				count++;
			}
		}
		System.out.println(i);
	}
}