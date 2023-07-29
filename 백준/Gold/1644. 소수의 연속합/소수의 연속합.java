import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer> primeArr = prime(N);

		if (N != 1) {
			int i = 0, j = 0, sum = primeArr.get(i), num = 0;
			while (i <= j && primeArr.size() != 0) {
				if (sum == N) {
					num++;
					sum -= primeArr.get(i);
					i++;

					if (i == primeArr.size()) {
						break;
					}
				}
				else if (sum < N) {
					j++;

					if (j == primeArr.size()) {
						break;
					}

					sum += primeArr.get(j);

				} else {
					sum -= primeArr.get(i);
					i++;

					if (i == primeArr.size()) {
						break;
					}
				}
			}

			System.out.println(num);
		}
		else {
			System.out.println(0);
		}


	}

	static ArrayList<Integer> prime(int n) {
		ArrayList<Integer> primeArr = new ArrayList();
		for (int i = 2; i <= n; i++) {
			boolean isPrime = true;
			for (int j = 2; j * j <= i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primeArr.add(i);
			}
		}
		return primeArr;
	}
}
