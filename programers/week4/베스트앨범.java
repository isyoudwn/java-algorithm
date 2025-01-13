import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> genresMap = new HashMap<>();
        HashMap<String, ArrayList<Integer>> genresWithIndex = new HashMap<>();
        
        
        // map setting
        for (int i = 0; i < genres.length; i++) {
            genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0) + plays[i]);
            
            genresWithIndex.put(genres[i], genresWithIndex.getOrDefault(genres[i], new ArrayList<>()));
            genresWithIndex.get(genres[i]).add(i);
        }
        
        ArrayList<String> keySet = new ArrayList<>(genresMap.keySet());
        
        keySet.sort((a, b) -> genresMap.get(b).compareTo(genresMap.get(a)));
        
        for (String key : keySet) {
            ArrayList<Integer> temp = genresWithIndex.get(key);
            
            if (temp.size() == 1) {
                answer.add(temp.get(0));
                continue;
            }
            
            temp.sort((a, b) -> Integer.compare(plays[b], plays[a]));
            
            answer.add(temp.get(0));
            answer.add(temp.get(1));
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
