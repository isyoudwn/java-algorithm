import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> numSet = new HashSet<>();
        Integer limit = nums.length / 2;
        
        for (int num : nums) {
            numSet.add(num);
        }
        
        return Math.min(limit, numSet.size());
    }
}