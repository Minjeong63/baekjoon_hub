import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     	int N = Integer.parseInt(br.readLine());   
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	ArrayList<Double> input = new ArrayList<Double>();
    	double max = Double.MIN_VALUE;
    	for (int i=0; i<N; i++) {
    		double input2 = Double.valueOf(st.nextToken());
    		input.add(input2);
    		if (input2 > max) max = input2;
    	}
    	double[] average = new double[N];
    	for (int i=0; i<N; i++) {
    		average[i] = Double.valueOf(input.get(i) / max * 100);
    	}
    	double sum = 0.0;
    	for (int i=0; i<N; i++) {
    		sum += average[i];
    	}
    	System.out.println(sum / N);
    }
}