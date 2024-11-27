import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int a : arr) {
            deque.add(a);
        }
        
        while (!deque.isEmpty()) {
            int top = deque.removeFirst();
            
            while (!deque.isEmpty() && top == deque.peekFirst()) {
                deque.removeFirst();
            } 
            answer.add(top);
        }
        
        
        return answer.stream()
            .mapToInt(Integer :: intValue)
            .toArray();
    }
}