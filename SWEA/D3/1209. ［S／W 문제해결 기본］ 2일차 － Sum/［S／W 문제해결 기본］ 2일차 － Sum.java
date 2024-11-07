import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = 0;
		while (count < 10) {
			
			count = Integer.parseInt(br.readLine());
			
			int max = Integer.MIN_VALUE;
			
			int[][] arr = new int[100][100];
			
			int leftCrossTotal = 0;
			int rightCrossTotal = 0;
			for (int i=0; i<100; i++) {
				
				int rowTotal = 0;
				
				String[] row = br.readLine().split(" ");
				for (int j=0; j<100; j++) {
					
					arr[i][j] = Integer.parseInt(row[j]);
					rowTotal += arr[i][j];
					
					if (i == j) {
						leftCrossTotal += arr[i][j];
					}
					
					if (i + j == 99) {
						rightCrossTotal += arr[i][j];
					}
				}
				
				max = Math.max(max, rowTotal);
				max = Math.max(max, leftCrossTotal);
				max = Math.max(max, rightCrossTotal);
			}
			
			for (int i=0; i<100; i++) {
				
				int columnTotal = 0;
				for (int j=0; j<100; j++) {
					columnTotal += arr[j][i];
				}
				
				max = Math.max(max, columnTotal);
			}
			System.out.printf("#%d %d%n", count, max);
		}
		
	}

}