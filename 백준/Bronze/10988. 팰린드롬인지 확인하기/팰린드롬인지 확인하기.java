import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuffer sb = new StringBuffer(str);
		String reversedStr = sb.reverse().toString();
		if (str.equals(reversedStr)) {
			System.out.println(1);
		} else System.out.println(0);
	}
}