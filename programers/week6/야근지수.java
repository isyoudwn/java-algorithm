import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        
        int workSum = Arrays.stream(works).sum();
        
        if (workSum <= n) {
            return 0;
        }
        
        // setting
        for (int work : works) {
            heap.add(work);
        }
        
        while (n != 0 && !heap.isEmpty()) {
            int element = heap.remove();
            element  = element - 1;
            n--;
            heap.add(element);
        }
        
        for (Integer h : heap) {
            answer += Long.valueOf(h) * Long.valueOf(h);
        }
        
        return answer;
    }
}
