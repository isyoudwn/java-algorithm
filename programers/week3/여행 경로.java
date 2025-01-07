import java.util.*;

class Solution {

    public String[] solution(String[][] tickets) {
        Map<String, ArrayList<String[]>> graph = new HashMap<>();
        
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        // graph setting
        for (String[] ticket : tickets) {
            graph.put(ticket[0], new ArrayList<>());
            graph.put(ticket[1], new ArrayList<>());
        }
        
        // create graph
        for (String[] ticket : tickets) {
            ArrayList<String[]> temp = graph.get(ticket[0]);
            String[] arr = {ticket[1], "X"};
            temp.add(arr);
            graph.put(ticket[0], temp);
        }
        
        Deque<String> path = new ArrayDeque<>();
        path.add("ICN");
        
        return dfs("ICN", graph, tickets.length + 1, path).toArray(String[]::new);
    }
    
    private Deque<String> dfs
        (String start, Map<String, ArrayList<String[]>> graph, int size, Deque<String> path) {
        
        if (path.size() == size) {
            return path;
        }
        
        for (String[] next : graph.get(start)) {
            if (!next[1].equals("O")) {
                path.add(next[0]);
                next[1] = "O";
                path = dfs(next[0], graph, size, path);
            
                if (path.size() < size && !path.isEmpty()) {
                    path.removeLast();
                    next[1] = "X";
                }
            } 
        }
        
        return path;
    }
}