import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double sum = 0.0;
		double score = 0;
		for (int i=0; i<20; i++) {
			String[] input = br.readLine().split(" ");
			if (!input[2].equals("P")) {
				if (input[2].equals("A+")) {
					sum += 4.5 * Double.valueOf(input[1]);
				} else if (input[2].equals("A0")) {
					sum += 4.0 * Double.valueOf(input[1]);
				} else if (input[2].equals("B+")) {
					sum += 3.5 * Double.valueOf(input[1]);
				}else if (input[2].equals("B0")) {
					sum += 3.0 * Double.valueOf(input[1]);
				}else if (input[2].equals("C+")) {
					sum += 2.5 * Double.valueOf(input[1]);
				}else if (input[2].equals("C0")) {
					sum += 2.0 * Double.valueOf(input[1]);
				}else if (input[2].equals("D+")) {
					sum += 1.5 * Double.valueOf(input[1]);
				}else if (input[2].equals("D0")) {
					sum += 1.0 * Double.valueOf(input[1]);
				}
				score += Double.valueOf(input[1]);
			}
		}
		System.out.println(sum / score);
    }
}