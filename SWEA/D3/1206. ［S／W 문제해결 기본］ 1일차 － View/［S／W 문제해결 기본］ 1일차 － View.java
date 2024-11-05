import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = 1;
		while (count <= 10) {

			int N = Integer.parseInt(br.readLine());
			String[] buildings = br.readLine().split(" ");
			
			int total = 0;
			for (int i = 0; i < N; i++) {
				int primaryBuilding = Integer.parseInt(buildings[i]);
				
				int max = 0;
				for (int j = i - 2; j <= i + 2; j++) {
					if (j < 0 || j == i || j >= N) {
						continue;
					}
					
					max = Math.max(Integer.parseInt(buildings[j]), max);
				}
				
				if (primaryBuilding > max) {
					total += (primaryBuilding - max);
				}
			}
			
			System.out.printf("#%d %d", count, total);
			System.out.println();
			count++;
		}

	}

}