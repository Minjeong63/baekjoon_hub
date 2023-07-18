import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dice = new int[3];
		dice[0] = Integer.parseInt(st.nextToken());
		dice[1] = Integer.parseInt(st.nextToken());
		dice[2] = Integer.parseInt(st.nextToken());
		if (dice[0] == dice[1] && dice[1] == dice[2]) {
			System.out.println(10000 + dice[0] * 1000);
		} else if (dice[0] != dice[1] && dice[1] != dice[2] && dice[0] != dice[2]) {
			int max = Math.max(dice[0], dice[1]);
			int realMax = Math.max(max, dice[2]);
			System.out.println(realMax * 100);
		} else if (dice[0] == dice[1]){
			System.out.println(1000 + dice[0]*100);
		} else if (dice[0] == dice[2]){
			System.out.println(1000 + dice[0]*100);
		} else if (dice[2] == dice[1]){
			System.out.println(1000 + dice[1]*100);
		}
	}
}