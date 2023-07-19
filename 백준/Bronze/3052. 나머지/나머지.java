import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] remainder = new int[42];
		int result = 0;
		for (int i=0; i<10; i++) {
			remainder[Integer.parseInt(br.readLine()) % 42] += 1;
		}
		for (int i=0; i<42; i++) {
			if (remainder[i] != 0) result++;
		}
		System.out.println(result);
    }
}