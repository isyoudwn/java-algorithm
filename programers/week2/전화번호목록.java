import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        String prefix = "";
        
        for (String phone : phone_book) {
            if (prefix.equals("")) {
                prefix = phone;
                continue;
            }
            
            if (phone.startsWith(prefix)) {
                return false;    
            }
            
            prefix = phone;
        }
        return true;
    }
}