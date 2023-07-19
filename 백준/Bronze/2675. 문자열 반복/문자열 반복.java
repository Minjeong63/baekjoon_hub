import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<num; i++) {
        	String input = br.readLine();
        	for (int j=0; j<input.split(" ")[1].length(); j++) {
        		sb.append(Character.toString(input.split(" ")[1].charAt(j)).repeat(Integer.parseInt(input.split(" ")[0])));
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
    }
}
