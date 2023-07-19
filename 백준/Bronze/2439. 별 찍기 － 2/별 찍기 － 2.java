import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		for (int i=1; i<=N; i++) {
			for (int j=N-i;j>0; j--) {
				sb2.append(" ");
			}
			sb1.append("*");
			sb2.append(sb1 + "\n");
		}
		System.out.println(sb2);
	}
}