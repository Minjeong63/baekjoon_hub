import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuffer sb1 = new StringBuffer("*");
		StringBuffer sb2 = new StringBuffer();
		StringBuffer sb3 = new StringBuffer();
		for (int i=0; i<N; i++) {
			if (i == 0) {
				for (int j=N-1; j>0; j--) {
					sb2.append(" ");
				}
			}
			if (i>0) {
				sb3.setLength(0);
				sb2.deleteCharAt(0);
				sb1.append("**");
			}
			sb3.append(sb2);
			sb3.append(sb1);
			System.out.println(sb3);
		}
		for (int i=0; i<N-1; i++) {
			sb3.setLength(0);
			sb2.append(" ");
			sb1.delete(0,2);
			sb3.append(sb2);
			sb3.append(sb1);
			System.out.println(sb3);
		}
	}
}