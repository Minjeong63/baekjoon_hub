import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int l = 0; l < T; l++) {
            st = new StringTokenizer(br.readLine());
            int teamNumber = Integer.parseInt(st.nextToken());
            int problemNumber = Integer.parseInt(st.nextToken());
            int teamId = Integer.parseInt(st.nextToken());
            int logNumber = Integer.parseInt(st.nextToken());

            // score[i][j]
            // i : 팀 id, j : 문제 번호
            Score[][] score = new Score[teamNumber + 1][problemNumber + 1];
            for (int r = 1; r <= logNumber; r++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                if (score[i][j] == null) {
                    score[i][j] = new Score(i, s, 1, r);
                } else {
                    if (score[i][j].getMaxScore() < s) {
                        score[i][j].setMaxScore(s);
                    }
                    score[i][j].setSubmissionNum(score[i][j].getSubmissionNum() + 1);
                    score[i][j].setSubmissionTime(r);
                }
            }

            Queue<Score> pq = new PriorityQueue<>(
                    Comparator.comparing(Score::getMaxScore).reversed()
                            .thenComparing(Score::getSubmissionNum)
                            .thenComparing(Score::getSubmissionTime)
            );

            for (int i = 1; i <= teamNumber; i++) {
                int scoreSum = 0;
                int submissionNum = 0;
                int submissionTime = 0;
                for (int j = 1; j <= problemNumber; j++) {
                    if (score[i][j] != null) {
                        scoreSum += score[i][j].getMaxScore();
                        submissionNum += score[i][j].getSubmissionNum();
                        submissionTime = Math.max(submissionTime, score[i][j].getSubmissionTime());
                    }
                }
                pq.add(new Score(i, scoreSum, submissionNum, submissionTime));
            }

            int rank = 1;
            while (true) {
                Score total = pq.poll();
                if (total.teamId == teamId) {
                    System.out.println(rank);
                    break;
                }
                rank++;
            }
        }
    }

    static class Score {
        int teamId;
        int maxScore;
        int submissionNum;
        int submissionTime;

        Score(int teamId, int maxScore, int submissionNum, int submissionTime) {
            this.teamId = teamId;
            this.maxScore = maxScore;
            this.submissionNum = submissionNum;
            this.submissionTime = submissionTime;
        }

        public int getMaxScore() {
            return maxScore;
        }

        public void setMaxScore(int score) {
            this.maxScore = score;
        }

        public int getSubmissionNum() {
            return submissionNum;
        }

        public void setSubmissionNum(int submissionNum) {
            this.submissionNum = submissionNum;
        }

        public int getSubmissionTime() {
            return submissionTime;
        }

        public void setSubmissionTime(int submissionTime) {
            this.submissionTime = submissionTime;
        }
    }
}