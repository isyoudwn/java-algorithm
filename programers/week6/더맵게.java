import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); 
        for (int s : scoville) {
            minHeap.add(s);
        }
        
        while(minHeap.size() > 1 && minHeap.peek() < K) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            
            int mixed = first + (second * 2);
            minHeap.add(mixed);
            answer++;
        }
        
        if (minHeap.peek() < K) {
            return -1;   
        }        
        
        return answer;
    }
}
