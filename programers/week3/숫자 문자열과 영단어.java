import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        Map<String, String> map = new HashMap<>();
        
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(sb.toString())) {
                answer.append(map.get(sb.toString()));
                sb.setLength(0);
            }

            if (Character.isDigit(s.charAt(i))) {
                System.out.println(s.charAt(i));
                answer.append(s.charAt(i));
                continue;
            }
            
            sb.append(s.charAt(i));    
            
                        
            if (i == s.length() - 1) {
                answer.append(map.get(sb.toString()));
            }  
        }
        
        return Integer.parseInt(answer.toString());
    }
}