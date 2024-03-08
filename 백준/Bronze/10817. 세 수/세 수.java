import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] arr = {Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])};
        Arrays.sort(arr);
        System.out.println(arr[1]);
    }
}