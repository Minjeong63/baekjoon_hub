import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		ArrayList<String> inputArr = new ArrayList<>(); 

		StringBuilder sb = new StringBuilder();

		for (int i=0; i<input.length(); i++) {
			if (input.charAt(i) == '+') {
				inputArr.add(sb.toString());
				inputArr.add("+");
				sb.setLength(0);

			} else if (input.charAt(i) == '-') {
				inputArr.add(sb.toString());
				inputArr.add("-");
				sb.setLength(0);

			} else {
				sb.append(input.charAt(i));
			}
		}
		inputArr.add(sb.toString());
		sb.setLength(0);
		sb.append("+");

		int sum = 0;

		for (int i=0; i<inputArr.size(); i++) {
			if (inputArr.get(i).equals("+")) {
				if (!sb.toString().equals("-")) {
					sb.setLength(0);
					sb.append("+");
					
				} else {
					continue;
				}

			} else if (inputArr.get(i).equals("-")) {
				sb.setLength(0);
				sb.append("-");

			} else {
				if (sb.toString().equals("+")) {
					sum += Integer.parseInt(inputArr.get(i));
					
				} else if (sb.toString().equals("-")) {
					sum -= Integer.parseInt(inputArr.get(i));
					
				}
			}
		}

		System.out.println(sum);

	}

}
