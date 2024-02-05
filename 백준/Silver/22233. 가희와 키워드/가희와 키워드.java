import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 구할 내용 : 블로그에 글을 쓰고 나서, 메모장에 있는 키워드 개수가 몇 개인지 구하기

// 지금까지 메모장에 써진 키워드는 모두 서로 다르며, 총 N개가 존재함
// 새로운 글을 작성할 때, 최대 10개의 키워드에 대해서 글을 작성함
// 이 키워드들 중에 메모장에 있었던 키워드는 가희가 글을 쓴 이후, 메모장에서 지워짐
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        Map<String, Integer> memo = new HashMap();
        for (int i = 0; i < N; i++) {
            memo.put(br.readLine(), 1);
        }

        StringBuilder sb = new StringBuilder();
        int cnt = N;
        for (int i = 0; i < M; i++) {
            String[] keywords = br.readLine().split(",");
            for (int j = 0; j < keywords.length; j++) {
                if (memo.containsKey(keywords[j])) {
                    memo.remove(keywords[j]);
                    cnt--;
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }
}