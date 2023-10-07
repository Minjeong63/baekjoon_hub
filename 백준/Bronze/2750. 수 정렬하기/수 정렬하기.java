import java.io.*;

/**
 * 버블 정렬로 풀어보기
 */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] numList = new int[N];
		for (int i=0; i<N; i++) {
			numList[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i=N-1; i>0; i--) {
			for (int j=0; j<i; j++) {
				if (numList[j] > numList[j+1]) {
					int changeNum = numList[j+1];
					numList[j+1] = numList[j];
					numList[j] = changeNum;
				}
			}
		}
		
		for (int i=0; i<N; i++) {
			System.out.println(numList[i]);
		}
		

	}

}
