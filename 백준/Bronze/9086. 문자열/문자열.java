import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main (String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int num = Integer.parseInt(br.readLine());
    	for (int i=0; i<num; i++) {
    		String s = "";
    		String str = br.readLine();
    		s += str.charAt(0);
    		s += str.charAt(str.length()-1);
    		System.out.println(s);
    	}
	}
}