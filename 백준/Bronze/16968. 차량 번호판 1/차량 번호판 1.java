import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int index = 0;
        char letter = 'a';
        int result = 1;

        while (index < input.length()) {
            char currentLetter = input.charAt(index);
            if (currentLetter != letter) {
                if (currentLetter == 'c') {
                    result *= 26;
                } else {
                    result *= 10;
                }
                letter = currentLetter;
            } else {
                if (currentLetter == 'c') {
                    result *= 25;
                } else {
                    result *= 9;
                }
            }
            index++;
        }
        System.out.println(result);
    }
}
