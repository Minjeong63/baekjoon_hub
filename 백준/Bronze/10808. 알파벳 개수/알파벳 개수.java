import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alphabet = new int[123];
        String[] input = br.readLine().split("");
        for (int i = 0; i < input.length; i++) {
            int index = input[i].charAt(0) - 0;
            alphabet[index]++;
        }
        for (int i = 97; i <= 122; i++) {
            System.out.print(alphabet[i] + " ");
        }
    }
}