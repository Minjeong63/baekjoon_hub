import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int one = Integer.parseInt(br.readLine());
		int two = Integer.parseInt(br.readLine());
		int three = one * (two%10);
		int four = one * ((two%100)/10);
		int five = one * (two/100);
		System.out.println(three);
		System.out.println(four);
		System.out.println(five);
		System.out.println(three + 10 * four + 100 * five);
	}
}