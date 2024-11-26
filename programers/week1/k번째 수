import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int[] command : commands) {
            ArrayList<Integer> list = new ArrayList<>();
            
            int start = command[0];
            int end = command[1];
            int k = command[2];

            
            for (int i = start - 1; i < end; i++) {
                list.add(array[i]);
            }
            
            // 정렬하기
            Collections.sort(list);
            answer.add(list.get(k - 1));
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
