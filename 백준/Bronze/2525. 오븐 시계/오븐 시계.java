import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());
		int take = Integer.parseInt(br.readLine());
		if (minute + take >= 60) {
			System.out.println(((hour + ((minute + take) / 60)) % 24) + " " + ((minute + take) % 60));
		} else {
			System.out.println(hour + " " + (minute + take));
		}
	}
}