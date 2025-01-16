import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        String[] arr = s.split(" ");
        
         for (String a : arr) {
             if (a.length() == 0) {
                 sb.append(" ");
                 continue;
             }
             
             else if (!Character.isDigit(a.charAt(0))) {
                 for (int i = 0; i < a.length(); i++) {
                     if(i == 0) {
                         sb.append(Character.toUpperCase(a.charAt(i)));
                     }
                     else {
                         sb.append(a.charAt(i));
                     }
                 }
             }
             
             else {
                 sb.append(a);
             }
            sb.append(" ");
        }
        
        sb.deleteCharAt(sb.length() - 1);
       
        if (s.endsWith(" ")) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
