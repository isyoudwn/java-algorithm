import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        int answer = 0;
        ArrayDeque<String> queue = new ArrayDeque<>();
        ArrayDeque<String> stack;
        
        for (String city : cities) {
            if (queue.isEmpty()) {
                queue.add(city);
                answer += 5;
            }
            
            else if (queue.contains(city)) {
                answer += 1;
                stack = new ArrayDeque<>();
                
                while (!queue.isEmpty()) {
                    String temp = queue.removeLast();
                    
                    if (temp.equals(city)) {
                        while (!stack.isEmpty()) {
                            queue.add(stack.pop());
                        }
                        queue.add(temp);
                        break;
                    }
                    
                    else {
                        stack.push(temp);
                    }
                }
            }
            
            else if (queue.size() == cacheSize) {
                queue.removeFirst();
                queue.add(city);
                answer += 5;
            }
            
            else {
                queue.add(city);
                answer += 5;
            }
        }
        
        return answer;
    }
}
