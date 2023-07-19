import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[][] inputArr = new String[5][15];
		for (int i=0; i<5; i++) {
			String[] input = br.readLine().split("");
			for (int j=0; j<input.length; j++) {
				inputArr[i][j] = input[j];
			}
		}
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<15; i++) {
			for (int j=0; j<5; j++) {
				if (inputArr[j][i] != null) sb.append(inputArr[j][i]);
			}
		}
		System.out.println(sb.toString());
	}
}