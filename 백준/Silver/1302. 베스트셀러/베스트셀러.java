import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (map.containsKey(input)) {
                map.put(input, map.get(input) + 1);
                continue;
            }
            map.put(input, 1);
        }

        int max = 0;
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> book : map.entrySet()) {
            if (book.getValue() > max) {
                max = book.getValue();
                sb.setLength(0);
                sb.append(book.getKey());
            }
            if (book.getValue() == max && (book.getKey().compareTo(sb.toString()) < 0)) {
                sb.setLength(0);
                sb.append(book.getKey());
            }
        }
        System.out.println(sb);
    }
}
