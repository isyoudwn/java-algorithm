import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<Integer> deque = new ArrayDeque<>();  
        
        for (int proiority : priorities) {
            deque.add(proiority);
        }
        

        int index = location;
        
        while (true) {
            int max = Collections.max(deque);
            int left = deque.remove();
            
            if (left == max) {
                
                if (index == 0) {
                    return ++answer;
                }
                
                index--;
                answer++;
                continue;
            }
            
            if (index == 0) {
                deque.add(left);
                index = index + deque.size() - 1;
                continue;
            }
            
            deque.add(left);
            index--;
        }
    }
}