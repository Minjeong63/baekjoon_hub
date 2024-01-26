import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // originalNumber : N의 최솟값
    // deletedNumberIndex : 지워진 수들 중 현재 가리키고 있는 수의 index
    // while (deletedNumberIndex가 지워진 수의 길이보다 작을 때만 반복) {
    //      originalNumber을 1부터 하나씩 늘리기
    //      minNumber : originalNumber를 String으로 변환
    //      for (minNumber의 길이만큼 반복) {
    //             if (minNumber에 deletedNumberIndex로 가리키는 수가 포함되어 있다면) {
    //                      deletedNumberIndex++;
    //                      if (deletedNumberIndex가 지워진 수의 길이랑 같으면) break;
    //             }
    //      }
    // }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] deletedNumber = br.readLine().split("");
        int originalNumber = 0;
        int deletedNumberIndex = 0;

        while (deletedNumberIndex < deletedNumber.length) {
            originalNumber++;

            String minNumber = String.valueOf(originalNumber);
            for (int i = 0; i < minNumber.length(); i++) {
                if (minNumber.charAt(i) == deletedNumber[deletedNumberIndex].charAt(0)) {
                    deletedNumberIndex++;
                    if (deletedNumberIndex == deletedNumber.length) {
                        break;
                    }
                }
            }
        }

        System.out.println(originalNumber);
    }
}