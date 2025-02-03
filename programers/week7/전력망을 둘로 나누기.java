import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        ArrayList<Integer> answers = new ArrayList<>();

        // graph setting
        for (int[] wire : wires) {
            graph.put(wire[0], new ArrayList<>());
            graph.put(wire[1], new ArrayList<>());
        }
        
        for (int [] wire : wires) {
            ArrayList<Integer> a = graph.get(wire[0]);
            ArrayList<Integer> b = graph.get(wire[1]);
            
            a.add(wire[1]);
            b.add(wire[0]);
            
            graph.put(wire[0], a);
            graph.put(wire[1], b);
        }
        
        ArrayList<Integer> keySet = new ArrayList<>(graph.keySet());
        
        // bfs 탐색
        for (int [] wire : wires) {
            int newResult = Math.abs(
                bfs(wire[0], graph, wire[0], wire[1]) - bfs(wire[1], graph, wire[0], wire[1])
            );
            answers.add(newResult);
        }
        
        Collections.sort(answers);
        
        return answers.get(0);
    }
    
    public int bfs(Integer start, Map<Integer, ArrayList<Integer>> graph, int a, int b) {
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> deque = new ArrayDeque<>();

        deque.add(start);
        visited.add(start);
        int node = 1;
        
        while (!deque.isEmpty()) {
            int now = deque.removeFirst();
            for (int next : graph.get(now)) {
                if ((now == a && next == b) || (next == a && now == b)) {
                    continue;
                }
                
                if (!visited.contains(next)) {
                    visited.add(next);
                    deque.add(next);
                    node++;
                }
            }
        }
        
        return node;
    } 
}
