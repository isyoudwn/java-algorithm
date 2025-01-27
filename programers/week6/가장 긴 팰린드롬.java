import java.util.*;

class Solution
{
    int answer = 0;
    
    public int solution(String s) {
        
        if (s.length() == 1) {
            return 1;
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
            palindrome(s, i, i + 1);
            palindrome(s, i, i + 2);
        }
        
        return answer;
    }
    
    public void palindrome(String word, int left, int right) {
        
        while (right < word.length() && left >= 0 && word.charAt(left) == word.charAt(right)) {
            left--;
            right++;
        }
        
        if (answer < (right - left - 1)) {
            answer = right - left - 1;
        }
    }
}
