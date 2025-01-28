import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[i] > numbers[stack.peekLast()]) {
                int top = stack.removeLast();
                answer[top] = numbers[i];
            }
            stack.add(i);
        }
        
        for (int i = 0; i < answer.length; i++) {
           if (answer[i] == 0) {
               answer[i] = -1;
           }
        }

        return answer;
    }
}
`