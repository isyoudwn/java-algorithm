import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[5];
        
        Integer[] intValue = Arrays.stream(num_list).boxed().toArray(Integer[]::new);
        Arrays.sort(intValue);
        
        
        for (int i = 0; i < 5; i++) {
            answer[i] = intValue[i];
        }
        return answer;
    }
}
