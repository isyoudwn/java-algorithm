import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";     
        
        List<String> numberList = new ArrayList<>();
        
        for (int number : numbers) {
            numberList.add(number + "");
        }
        
        numberList.sort((n1, n2) -> (n2 + n1).compareTo(n1 + n2));
        
        StringBuilder sb = new StringBuilder();
        
        for (String number : numberList) {
            sb.append(number);        
        }
        
        answer = sb.toString();
        
        if (answer.charAt(0) == '0') {
            return "0";
        }
        
        return answer;
    }
}