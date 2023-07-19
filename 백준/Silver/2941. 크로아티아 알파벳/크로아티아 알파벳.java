import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer(br.readLine());
		int result = 0;
		for (int i=0; i<sb.length(); i++) {
			if (sb.charAt(i) == 'c' && i <= sb.length() - 2 && (sb.charAt(i+1) == '=' || sb.charAt(i+1) == '-')) {
				i = i+1;
			} else if (sb.charAt(i) == 'd') {
				if (i <= sb.length() - 3 && sb.charAt(i+1) == 'z' && sb.charAt(i+2) == '='  ) {
				i = i+2;
				} else if (i <= sb.length() - 2 && sb.charAt(i+1) == '-') {
					i = i+1;
				}
			} else if (sb.charAt(i) == 'l' && i <= sb.length() - 2 && sb.charAt(i+1) == 'j') {
				i = i+1;
			} else if (sb.charAt(i) == 'n' && i <= sb.length() - 2 && sb.charAt(i+1) == 'j') {
				i = i+1;
			} else if (sb.charAt(i) == 's' && i <= sb.length() - 2 && sb.charAt(i+1) == '=') {
				i = i+1;
			} else if (sb.charAt(i) == 'z' && i <= sb.length() - 2 && sb.charAt(i+1) == '=') {
				i = i+1;
			} 
			result++;
		}
		System.out.println(result);
	}
}