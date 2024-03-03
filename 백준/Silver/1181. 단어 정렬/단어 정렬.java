import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        List<Word> list = new ArrayList<>();
        for (String word : set) {
            list.add(new Word(word));
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (Word word : list) {
            sb.append(word.word + "\n");
        }
        System.out.println(sb);

    }

    static class Word implements Comparable<Word> {
        String word;

        Word(String word) {
            this.word = word;
        }

        @Override
        public int compareTo(Word w) {
            if (word.length() < w.word.length()) {
                return -1;
            } else if (word.length() == w.word.length()) {
                return word.compareTo(w.word);
            }
            return 1;
        }
    }
}