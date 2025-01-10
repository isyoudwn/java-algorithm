import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n + 1];
        Map<Integer, Integer> path = new HashMap<>();        
        
        // graph setting
        for (int[] e : edge) {
            int from = e[0];
            int to = e[1];
            
            graph.put(from, new ArrayList<>());
            graph.put(to, new ArrayList<>());
            path.put(from, 0);
            path.put(to, 0);
        }
        
        for (int[] e : edge) {
            int from = e[0];
            int to = e[1];
            
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        
        // bfs
        path = bfs(1, graph, visited, path);
        
        // 최대값 찾기
        Integer maxValue = Collections.max(path.values());
        
        for (Integer p : path.keySet()) {
            if (maxValue.equals(path.get(p))) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private Map<Integer, Integer> bfs(int start, Map<Integer, ArrayList<Integer>> graph, 
                     boolean[] visited, Map<Integer, Integer> path) {
        
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        
        // base-case
        deque.add(start);
        visited[start] = true;
        
        while (!deque.isEmpty()) {
            
            Integer now = deque.removeFirst();
            
            for (int next : graph.get(now)) {
                if (visited[next]) {
                    continue;
                }   
                deque.addLast(next);
                visited[next] = true;
                path.put(next, path.get(now) + 1);
            }
        }
        return path;
    }
}
