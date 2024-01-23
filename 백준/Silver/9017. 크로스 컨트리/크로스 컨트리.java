import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 팀 점수는 상위 네 명의 주자의 점수를 합하여 계산
// - 여섯 명의 주자가 참가하지 못한 팀은 점수 계산 제외
// - 점수를 더하여 가장 낮은 점수를 얻는 팀이 우승하게 됨
// - 동점의 경우에는, 다섯 번째 주자가 가장 빨리 들어온 팀이 우승하게 됨
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            String[] teamInput = br.readLine().split(" ");
            // index를 점수라고 생각하고 해당 점수를 얻은 팀 선수를 저장
            int[] score = new int[N + 1];
            // team 별로 몇 명의 주자가 참여했는지 저장
            int[] team = new int[201];
            for (int j = 0; j < N; j++) {
                score[j + 1] = Integer.parseInt(teamInput[j]);
                team[score[j + 1]]++;
            }

            int[] possibleScore = new int[N + 1];
            int idx = 1;
            for (int j = 0; j < score.length; j++) {
                if (team[score[j]] == 6) {
                    possibleScore[idx] = score[j];
                    idx++;
                }
            }

            List<Node> minScoreSum = new ArrayList<>();
            int min = Integer.MAX_VALUE;
            for (int j = 1; j < team.length; j++) {
                if (team[j] == 6) {
                    int index = 0;
                    int sumToFour = 0;
                    for (int k = 1; k <= possibleScore.length; k++) {
                        if (possibleScore[k] == j) {
                            index++;
                            if (index <= 4) {
                                sumToFour += k;
                            }

                            if (index == 4) {
                                min = Math.min(min, sumToFour);

                            }

                            if (index == 5) {
                                minScoreSum.add(new Node(j, sumToFour, k));
                                break;
                            }
                        }
                    }
                }
            }
            int result = 0;
            int fifth = Integer.MAX_VALUE;
            for (int j = 0; j < minScoreSum.size(); j++) {
                if (minScoreSum.get(j).sum == min) {
                    if (minScoreSum.get(j).fifth < fifth) {
                        fifth = minScoreSum.get(j).fifth;
                        result = minScoreSum.get(j).team;
                    }
                }
            }
            System.out.println(result);
        }
    }

    static class Node {
        int team;
        int sum;
        int fifth;

        Node(int team, int sum, int fifth) {
            this.team = team;
            this.sum = sum;
            this.fifth = fifth;
        }
    }
}