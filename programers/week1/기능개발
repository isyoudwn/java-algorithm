import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> queue = new ArrayList<>();
        List<Integer> speedQueue = new ArrayList<>();
        
        for (int progress : progresses) {
            queue.add(progress);
        }
        
        for (int speed : speeds) {
            speedQueue.add(speed);
        }
        
        while (!queue.isEmpty()) {
            
            for (int i = 0; i < speedQueue.size(); i++) {
                queue.set(i, queue.get(i) + speedQueue.get(i));
            }
            
            int front = queue.get(0);
            
            if (front >= 100) {
                int count = 0;
                while(!queue.isEmpty() && queue.get(0) >= 100) {
                    queue.remove(0);
                    speedQueue.remove(0);
                    count++;
                }
                answer.add(count);
            }
        }

            
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}