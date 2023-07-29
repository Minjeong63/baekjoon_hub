class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int i = 0, j = 0, sum = sequence[i];
        int length = sequence.length;
        
        while (i < length && j < length) {
            System.out.println(i + " " + j);
            if (sum < k) {
                j++;
                sum += sequence[j];
            } else if (sum > k) {
                sum -= sequence[i];
                i++;
            } else {
                answer[0] = i;
                answer[1] = j;
                j++;
                if (j < length) {
                    sum += sequence[j];
                }
            }
        }
        return answer;
    }
}