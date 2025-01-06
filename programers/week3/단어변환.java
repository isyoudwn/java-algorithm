import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        List<Integer> answers = new ArrayList<>();
        
        Map<String, ArrayList<String>> graph = new HashMap<>();
        Map<String, Boolean> visited = new HashMap<>();
        
        if (!Arrays.stream(words).anyMatch(target::equals)) {
            return 0;
        }
        
        // key 세팅
        graph.put(begin, new ArrayList<>());
        visited.put(begin, false);
        
        for (String word : words) {
            graph.put(word, new ArrayList<>());
            visited.put(word, false);
        }
        
        // 1개 차이인 애들 엮어주기
        for (String key : graph.keySet()) {
            ArrayList<String> value = graph.get(key);
            
            for (String word : words) {
                if (compare(word, key)) {
                    value.add(word);
                    graph.put(key, value);
                }
            }
        }
        
        // back-track 시작
        backTrack(begin, target, answer, visited, graph, answers);
        
        return Collections.min(answers);
    }
    
    public void backTrack(String start, String target, int answer, Map<String, Boolean> visited, 
                          Map<String, ArrayList<String>> graph, List<Integer> answers) {
        
        if (start.equals(target)) {
            answers.add(answer);
            return;
        }
    
        
        for (String next : graph.get(start)) {
            if (visited.get(next) == true) {
                continue;
            }
            
            visited.put(next, true);
            answer++;
            backTrack(next, target, answer, visited, graph, answers);
            visited.put(next, false);
            answer--;
        }
    }
    
    public boolean compare(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        
        return count == 1;
    }
}
