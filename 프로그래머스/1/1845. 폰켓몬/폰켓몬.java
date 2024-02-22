class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int[] cnt = new int[200_001];
        for (int i=0; i<nums.length; i++) {
            cnt[nums[i]]++;
        }
        
        for (int i=0; i<cnt.length; i++) {
            if (cnt[i] != 0) {
                answer++;
            }
        }
        
        return answer > nums.length / 2 ? nums.length / 2 : answer;
    }
}