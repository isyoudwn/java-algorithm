import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> temp = new ArrayDeque<>();
        int N = s.length();
        
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == '(') {
                temp.add(s.charAt(i));
                continue;
            }
            
            if (s.charAt(i) == ')') {
                if (temp.isEmpty()) {
                    return false;
                }
                temp.remove();
                continue;
            }
        }
        
        
        if (!temp.isEmpty()) {
            return false;
        }
        return true;
    }
}