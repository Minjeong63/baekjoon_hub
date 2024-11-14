import java.io.*;
import java.util.*;


/**
 * 2024. 11. 14 목
 * 
 * - 요구 사항 분석
 * 1. . : 평지(전차 진입 가능)
 * 2. * : 벽돌로 만들어진 벽
 * 3. # : 강철로 만들어진 벽
 * 4. - : 물(전차 진입 XXXX)
 * 5. ^ : 위를 바라보는 전차(아래는 평지)
 * 6. v : 아래쪽을 바라보는 전차(아래는 평지)
 * 7. < : 왼쪽을 바라보는 전차(아래는 평지)
 * 8. > : 오른쪽을 바라보는 전차(아래는 평지)
 * 
 * - 사용자가 넣을 수 있는 입력
 * 1. U : 전차가 바라보는 방향을 위로 바꾸고, 한 칸 위의 칸이 평지라면 그 칸으로 이동
 * 2. D : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동
 * 3. L : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동
 * 4. R : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동
 * 5. S : 전차가 현재 바라보 있는 방향으로 포탄을 발사
 * 
 * - 전차가 이동할 때, 게임 맵 밖이라면 이동 X
 * - 전차가 포탄을 발사하면, 포탄은 벽돌로 만들어진 벽 또는 강철로 만들어진 벽에 충돌하거나 게임 맵 밖으로 나갈 때까지 직진
 * - 포탄이 벽에 부딪히면 포탄 소멸, 부딪힌 벽이 벽돌이면 이 벽은 파괴되어 평지가 됨
 * - 포탄이 강철 벽에 부딪히면 아무 일도 없음
 * - 게임 맵 밖으로 포탄이 나가면 아무 일도 없음
 * 
 * 
 * 구해야 할 것 : 모든 입력을 처한 다음 게임 맵의 상태가 어떻게 되는 지 구하기!!
 * 
 */
public class Solution {
	static int H;
	static int W;
	static String[][] gameMap;
	static int count = 1;
	static int[] carPosition;
	static int[] carDirection;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while (count <= T) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken()); // 높이
			W = Integer.parseInt(st.nextToken()); // 너비
			
			carPosition = new int[2]; // 전차 위치
			carDirection = new int[2]; // 전차 방향
			
			gameMap = new String[H][W];
			for (int i=0; i<H; i++) {
				String[] map = br.readLine().split("");
				for (int j=0; j<W; j++) {
					gameMap[i][j] = map[j];
					
					// 전차 방향 저장
					if (gameMap[i][j].equals("^")) {
						carDirection[0] = -1;
						carDirection[1] = 0;
						
						carPosition[0] = i;
						carPosition[1] = j;
						
					} else if (gameMap[i][j].equals("v")) {
						carDirection[0] = 1;
						carDirection[1] = 0;
						
						carPosition[0] = i;
						carPosition[1] = j;
						
					} else if (gameMap[i][j].equals("<")) {
						carDirection[0] = 0;
						carDirection[1] = -1;
						
						carPosition[0] = i;
						carPosition[1] = j;
						
					} else if (gameMap[i][j].equals(">")) {
						carDirection[0] = 0;
						carDirection[1] = 1;
						
						carPosition[0] = i;
						carPosition[1] = j;
						
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine()); // 사용자의 입력 개수
			String[] inputs = br.readLine().split("");
			
			for (String input : inputs) {
				if (input.equals("U")) {
					move(-1, 0, "^");
					
				} else if (input.equals("D")) {
					move(1, 0, "v");
					
				} else if (input.equals("L")) {
					move(0, -1, "<");
					
				} else if (input.equals("R")) {
					move(0, 1, ">");
					
				} else if (input.equals("S")) {
					int x = carPosition[0];
					int y = carPosition[1];
					
					// 위
					if (carDirection[0] == -1) {
						int changeX = x;
						while (changeX >= 0) {
							if (!isMoveS(changeX, y)) {
								break;
							}
							changeX = changeX + carDirection[0];
						}
						
						
						// 아래
					} else if (carDirection[0] == 1) {
						int changeX = x;
						while (changeX < H) {
							if (!isMoveS(changeX, y)) {
								break;
							}
							changeX = changeX + carDirection[0];
						}
						
						
						// 왼
					} else if (carDirection[1] == -1) {
						int changeY = y;
						while (changeY >= 0) {
							if (!isMoveS(x, changeY)) {
								break;
							}
							changeY = changeY + carDirection[1];
						}
						
						
						// 오
					} else if (carDirection[1] == 1) {
						int changeY = y;
						while (changeY < W) {
							if (!isMoveS(x, changeY)) {
								break;
							}
							changeY = changeY + carDirection[1];
						}
					}
					
				}
	
			}
			
			printOutput();
			count++;
		}
	}
	
	static void move(int directX, int directY, String shape) {
		carDirection[0] = directX;
		carDirection[1] = directY;
		
		gameMap[carPosition[0]][carPosition[1]] = shape;
		
		int posX = carPosition[0] + carDirection[0];
		int posY = carPosition[1] + carDirection[1];
		
		if (posX < 0 || posY < 0 || posX >= H || posY >= W) {
			return;
		}
		
		if (gameMap[posX][posY].equals(".")) {
			gameMap[posX][posY] = shape;
			gameMap[carPosition[0]][carPosition[1]] = ".";
			
			carPosition[0] = posX;
			carPosition[1] = posY;
		}
	}
	
	static boolean isMoveS(int x, int y) {
		String movePos = gameMap[x][y];
		if (movePos.equals("*")) {
			gameMap[x][y] = ".";
			return false;
		} else if (movePos.equals("#")) {
			return false;
		}
		return true;
	}
	
	static void printOutput() {
		StringBuilder output = new StringBuilder();
		for (int i=0; i<H; i++) {
			for (int j=0; j<W; j++) {
				output.append(gameMap[i][j]);
			}
			
			if (i < H-1) {
				output.append("\n");
			}
		}
		System.out.printf("#%d %s%n", count, output);
	}

}