import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        Map<String, ArrayList<String>> map = new HashMap<>();

        // setting
        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String key = String.valueOf(charArr);

            if (!map.containsKey(key)) {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(key, temp);
            }
            else {
                ArrayList<String> temp = map.get(key);
                temp.add(str);
                map.put(key, temp);
            }
        }

        String[] keys = map.keySet().stream().toArray(String[]::new);
        
        Arrays.sort(keys, (a, b) -> Integer.compare(map.get(a).size(), map.get(b).size()));

        for (String key : keys) {
            List<String> value = map.get(key);
            answer.add(value);
        }

        return answer;
    }
}
