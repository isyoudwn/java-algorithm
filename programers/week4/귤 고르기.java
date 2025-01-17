import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        // 1:1, 3:2, 2:2, 4:1, 5:2
        // 
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        
        // 내림자순
        Collections.sort(keys, (a, b) -> (map.get(b).compareTo(map.get(a))));
        
        int temp = 0;
        
        for (Integer key : keys) {
            
            temp = temp + map.get(key);
            answer++;
            
            if (temp >= k) {
                return answer;
            }
        }
        
        return answer;
    }
}
