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
		if (hour == 0 && minute < 45) {
			System.out.println(23 + " " + (minute + 60 - 45));
		} else if (minute < 45) {
			System.out.println(hour-1 + " " + (minute + 60 - 45));
		} else {
			System.out.println(hour + " " + (minute - 45));
		}
	}
}