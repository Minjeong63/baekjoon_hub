import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// *** 규칙에 따라 볼을 이동하여 같은 색끼리 모을 때 최소 이동횟수 구하는 문제
// 볼을 옮기는 규칙
//      1. 바로 옆에 다른 색깔의 볼이 있으면 그 볼을 모두 뛰어 넘어 옮길 수 있음
//      2. 옮길 수 있는 볼의 색깔은 한 가지임
// 문자열에 R 또는 B 중 한 종류만 주어진다면 답은 0임
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String balls = br.readLine();

        int answer = Integer.MAX_VALUE;

        int firstBallCnt = 0;
        int totalRedBall = 0;
        int totalBlueBall = 0;
        for (int i = 0; i < N; i++) {
            if (balls.charAt(i) == 'B') {
                totalBlueBall++;
            } else {
                totalRedBall++;
            }
        }

        // 왼쪽에 파란공 옮기기
        if (balls.charAt(0) == 'R') {
            answer = Math.min(answer, totalBlueBall);
        } else {
            firstBallCnt = 0;
            for (int i = 0; i < N; i++) {
                if (balls.charAt(i) == 'R') {
                    break;
                }
                firstBallCnt++;
            }
            answer = Math.min(answer, totalBlueBall - firstBallCnt);
        }

        // 왼쪽에 빨간공 옮기기
        if (balls.charAt(0) == 'B') {
            answer = Math.min(answer, totalRedBall);
        } else {
            firstBallCnt = 0;
            for (int i = 0; i < N; i++) {
                if (balls.charAt(i) == 'B') {
                    break;
                }
                firstBallCnt++;
            }
            answer = Math.min(answer, totalRedBall - firstBallCnt);
        }

        // 오른쪽에 파란공 옮기기
        if (balls.charAt(N - 1) == 'R') {
            answer = Math.min(answer, totalBlueBall);
        } else {
            firstBallCnt = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (balls.charAt(i) == 'R') {
                    break;
                }
                firstBallCnt++;
            }
            answer = Math.min(answer, totalBlueBall - firstBallCnt);
        }

        // 오른쪽에 빨간공 옮기기
        if (balls.charAt(N - 1) == 'B') {
            answer = Math.min(answer, totalRedBall);
        } else {
            firstBallCnt = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (balls.charAt(i) == 'B') {
                    break;
                }
                firstBallCnt++;
            }
            answer = Math.min(answer, totalRedBall - firstBallCnt);
        }
        System.out.println(answer);
    }
}