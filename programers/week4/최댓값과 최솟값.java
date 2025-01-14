import java.util.*;
import java.util.stream.*;


class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        
        List<Integer> a = Arrays.stream(arr).map(Integer::parseInt).collect(Collectors.toList());
        
        int max = Collections.max(a);
        int min = Collections.min(a);
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(min);
        sb.append(" ");
        sb.append(max);
        
        return sb.toString();
    }
}
