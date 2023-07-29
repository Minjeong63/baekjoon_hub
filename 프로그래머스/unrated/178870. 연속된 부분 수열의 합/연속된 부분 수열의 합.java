class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int i = 0, j = 0, sum = sequence[i];
        int length = Integer.MAX_VALUE;
        
        while (i <= j && i < sequence.length) {
            if (sum == k) {
                if (length > j - i) {
                    length = j - i;
                    answer[0] = i;
                    answer[1] = j;
                }
                sum -= sequence[i++];
            } else if (sum > k) {
                sum -= sequence[i++];
            } else {
                if (j == sequence.length-1) {
                    break;
                }
                sum += sequence[++j];
            }
        }
        return answer;
    }
}