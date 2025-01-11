import java.util.*;

class Solution {
    public int[] solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        s = s.replaceAll("\\{", "");
        s = s.replaceAll("}", "");
        
        String[] arr = s.split(",");

        for (String a : arr) {
            Integer intValue = Integer.parseInt(a);
            map.put(intValue, map.getOrDefault(intValue, 0) + 1);
        }
        
        List<Integer> keys = new ArrayList<>(map.keySet());
        
        keys.sort((a, b) -> map.get(b).compareTo(map.get(a)));
        
        for (Integer key : keys) {
            answer.add(key);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
