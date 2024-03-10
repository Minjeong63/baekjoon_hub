import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Member> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            list.add(new Member(i, Integer.parseInt(input[0]), input[1]));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (Member m : list) {
            sb.append(m.age + " " + m.name + "\n");
        }
        System.out.println(sb);
    }

    static class Member implements Comparable<Member> {
        int id;
        int age;
        String name;

        Member(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member m) {
            if (age < m.age) {
                return -1;
            } else if (age == m.age) {
                return id - m.id;
            }
            return 1;
        }
    }
}