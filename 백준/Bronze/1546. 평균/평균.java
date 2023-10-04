import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int N = Integer.parseInt(br.readLine());
		String[] inputList = br.readLine().split(" ");

		float max = 0;
		for (int i=0; i<inputList.length; i++) {
			max = Math.max(max, Integer.parseInt(inputList[i]));
		}

		float sum = 0;
		for (int i=0; i<inputList.length; i++) {
			sum += (Integer.parseInt(inputList[i]) / max * 100);
		}

		System.out.println(sum / N);

	}
}