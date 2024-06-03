import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] seatLoveStudent;
    static Position[] seatPosition;
    static int[][] inputArr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 자리마다 앉은 학생을 저장
        seatLoveStudent = new int[N + 1][N + 1];

        int numberOfStudents = N * N;

        // index에 해당하는 학생이 앉았는 지 확인하는 배열
        seatPosition = new Position[numberOfStudents + 1];

        inputArr = new int[numberOfStudents + 1][4];

        StringTokenizer st;
        for (int i = 0; i < numberOfStudents; i++) {
            st = new StringTokenizer(br.readLine());

            int studentNumber = Integer.parseInt(st.nextToken());

            int[] loveStudent = new int[4];
            for (int j = 0; j < 4; j++) {
                loveStudent[j] = Integer.parseInt(st.nextToken());
                inputArr[studentNumber][j] = loveStudent[j];
            }

            ArrayList<Position> posList = printMaxLoveStudentNearPositionList(loveStudent);

            Position pos;
            if (posList.size() == 1) {
                pos = posList.get(0);

            } else {
                posList = printNumberOfNearEmptyPosition(posList);
                pos = printPosition(posList);

            }

            seatLoveStudent[pos.x][pos.y] = studentNumber;
            seatPosition[studentNumber] = new Position(pos.x, pos.y);
        }

        printSatisfactionScore();
    }

    // 인접하는 좋아하는 학생들의 수를 구한 다음, 그 수가 가장 많을 때의 자리들을 list로 반환하는 메서드
    static ArrayList<Position> printMaxLoveStudentNearPositionList(int[] loveStudent) {
        int maxLoveStudentNum = 0;
        ArrayList<Position> posList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {

                if (seatLoveStudent[i][j] != 0) {
                    continue;
                }

                int nearLoveStudentNum = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx <= 0 || nx > N || ny <= 0 || ny > N) {
                        continue;
                    }

                    if (seatLoveStudent[nx][ny] == 0) {
                        continue;
                    }

                    for (int loveStudentNum : loveStudent) {
                        if (seatLoveStudent[nx][ny] == loveStudentNum) {
                            nearLoveStudentNum++;
                            break;
                        }
                    }
                }

                if (nearLoveStudentNum > maxLoveStudentNum) {
                    maxLoveStudentNum = nearLoveStudentNum;

                    posList.clear();
                    posList.add(new Position(i, j));
                } else if (nearLoveStudentNum == maxLoveStudentNum) {
                    posList.add(new Position(i, j));
                }
            }
        }

        return posList;
    }

    // 가장 많은 비어 있는 인접한 칸을 가진 위치들을 list로 반환하는 메서드
    static ArrayList<Position> printNumberOfNearEmptyPosition(ArrayList<Position> posList) {

        int maxEmptyPos = 0;
        ArrayList<Position> maxEmptyPosList = new ArrayList<>();

        for (Position pos : posList) {
            int numberOfEmptyPosition = 0;

            for (int i = 0; i < 4; i++) {

                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx <= 0 || nx > N || ny <= 0 || ny > N) {
                    continue;
                }

                if (seatLoveStudent[nx][ny] == 0) {
                    numberOfEmptyPosition++;
                }
            }

            if (numberOfEmptyPosition > maxEmptyPos) {
                maxEmptyPos = numberOfEmptyPosition;

                maxEmptyPosList.clear();
                maxEmptyPosList.add(pos);
            } else if (numberOfEmptyPosition == maxEmptyPos) {
                maxEmptyPosList.add(pos);
            }
        }

        return maxEmptyPosList;
    }

    static Position printPosition(ArrayList<Position> posList) {
        Position answer = posList.get(0);
        for (Position pos : posList) {
            if (pos.x < answer.x || (pos.x == answer.x && pos.y < answer.y)) {
                answer = pos;
            }
        }
        return answer;
    }

    static void printSatisfactionScore() {
        int totalScore = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {

                int score = 0;

                for (int k = 0; k < 4; k++) {

                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx <= 0 || nx > N || ny <= 0 || ny > N) {
                        continue;
                    }

                    for (int num : inputArr[seatLoveStudent[i][j]]) {
                        if (seatLoveStudent[nx][ny] == num) {
                            score++;
                        }
                    }
                }

                if (score == 1) {
                    totalScore++;
                } else {
                    totalScore += Math.pow(10, (score - 1));
                }
            }
        }
        System.out.println(totalScore);
    }

    static class Position {
        final int x;
        final int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}