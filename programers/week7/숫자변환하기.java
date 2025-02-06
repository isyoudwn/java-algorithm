import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(x, 0);
        map.put(x + n, 1);
        map.put(x * 2, 1);
        map.put(x * 3, 1);
        
        for (int i = x; i < y + 1 ; i++) {
            if (!map.containsKey(i)) {
                continue;
            }
            if (!map.containsKey(i * 2)) {
                map.put(i * 2, map.get(i) + 1);   
            } else {
                map.put(i * 2, Math.min(map.get(i * 2), map.get(i) + 1));
            }
            
            if (!map.containsKey(i * 3)) {
                map.put(i * 3, map.get(i) + 1);   
            } else {
                map.put(i * 3, Math.min(map.get(i * 3), map.get(i) + 1));
            }
            
            if (!map.containsKey(i + n)) {
                map.put(i + n, map.get(i) + 1);   
            } else {
                map.put(i + n, Math.min(map.get(i + n), map.get(i) + 1));
            }
        }
        
        return map.get(y) == null ? -1 : map.get(y);
    }
}
