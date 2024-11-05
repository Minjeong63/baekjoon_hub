import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = 1;
		while (count <= 10) {
			int N = Integer.parseInt(br.readLine());
			String[] boxes = br.readLine().split(" ");
			int[] boxesConvertInt = new int[100];
			for (int i=0; i<100; i++) {
				boxesConvertInt[i] = Integer.parseInt(boxes[i]);
			}
			
			Arrays.sort(boxesConvertInt);
			
			for (int i=0; i<N; i++) {
				boxesConvertInt[0]++;
				boxesConvertInt[99]--;
				
				if (boxesConvertInt[0] > boxesConvertInt[1] || boxesConvertInt[98] > boxesConvertInt[99]) {
					Arrays.sort(boxesConvertInt);
				}
			}
			System.out.printf("#%d %d%n", count, (boxesConvertInt[99] - boxesConvertInt[0]));
			count++;
		}
	}

}