import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String current = "";
        String sign = "+";
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != '-' && input.charAt(i) != '+') {
                current += input.charAt(i);
            } else if (input.charAt(i) == '-') {
                if (sign.equals("+")) {
                    result += Integer.parseInt(current);
                    current = "";
                    sign = "-";
                } else {
                    result -= Integer.parseInt(current);
                    current = "";
                }
            } else {
                if (sign.equals("-")) {
                    result -= Integer.parseInt(current);
                    current = "";
                } else {
                    result += Integer.parseInt(current);
                    current = "";
                }

            }
        }
        if (sign.equals("+")) {
            result += Integer.parseInt(current);
        } else {
            result -= Integer.parseInt(current);
        }
        System.out.println(result);
    }
}