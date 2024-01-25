import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    // 길이가 M이상인 단어들만 단어장에 포함
    // 단어장의 단어 순서는 우선순위를 차례로 만들어짐
    // 1. 자주 나오는 단어일수록 앞에 배치
    // 2. 단어의 길이가 길수록 앞에 배치
    // 3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                if (map.containsKey(word)) {
                    map.replace(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
        }

        Queue<Word> pq = new PriorityQueue<>((o1, o2) ->
                o1.frequent != o2.frequent ? o2.frequent - o1.frequent :
                        o1.wordLength != o2.wordLength ? o2.wordLength - o1.wordLength :
                                o1.word.compareTo(o2.word));
        for (Entry<String, Integer> word : map.entrySet()) {
            pq.add(new Word(word.getValue(), word.getKey().length(), word.getKey()));
        }

        while (!pq.isEmpty()) {
            Word word = pq.poll();
            bw.write(word.word + "\n");
        }
        bw.flush();
        bw.close();

    }

    static class Word {
        int frequent;
        int wordLength;
        String word;

        Word(int frequent, int wordLength, String word) {
            this.frequent = frequent;
            this.wordLength = wordLength;
            this.word = word;
        }
    }
}