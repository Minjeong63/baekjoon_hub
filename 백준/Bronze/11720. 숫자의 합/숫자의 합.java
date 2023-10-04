import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		
		String[] numberList = input.split("");
		
		int result = 0;
		for (int i=0; i<N; i++) {
			result += Integer.parseInt(numberList[i]);
		}
		
		System.out.println(result);
	}

}