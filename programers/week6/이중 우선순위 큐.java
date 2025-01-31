import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        // 최소 최대
        Queue<Integer> minQ = new PriorityQueue<>();
        Queue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String operation : operations) {
            if (operation.startsWith("I")) {
                int temp = Integer.parseInt(operation.replaceAll("I ", ""));
                
                minQ.add(temp);
                maxQ.add(temp);
            }
            
            else {
                String temp = operation.replaceAll("D ", "");
                
                if (minQ.isEmpty() || maxQ.isEmpty()) {
                    continue;
                }
                
                else if (temp.equals("1")) {
                    minQ.remove((maxQ.poll()));
                }
                else {
                    maxQ.remove((minQ.poll()));
                }
            }
        }
        
        if (minQ.isEmpty() || maxQ.isEmpty()) {
            return new int[] {0,0};
        }
        
        return new int[] {maxQ.poll(), minQ.poll()};
    }
}
