import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();
        ArrayList<Integer> answer = new ArrayList<>();
        int N = prices.length;
        
        for (int i = 0; i < N; i++) {
            deque.add(prices[i]);
        }
        
        while(!deque.isEmpty()) {
            
            if (deque.size() == 1) {
                answer.add(0);
                break;
            }
            
            Integer front = deque.remove();
            
            int sec = 0;
            for (Integer number : deque) {
                sec++;
                if (front > number) {
                    break;
                }
            }
            
            answer.add(sec);
        }
        
        return answer.stream().mapToInt(Integer :: intValue).toArray();
    }
}