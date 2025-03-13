class Solution {

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> graph = new HashMap<>();
        Deque<String> path = new ArrayDeque<>();

        // graph-setting
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            Queue<String> temp = graph.getOrDefault(from, new PriorityQueue<>());
            temp.add(to);
            graph.put(from, temp);
        }
        
        dfs("JFK", graph, path);

        return new ArrayList<>(path);
    }

    public void dfs(String start, Map<String, Queue<String>> graph, Deque<String> path) {

        while (graph.containsKey(start) && !graph.get(start).isEmpty()) {
            dfs(graph.get(start).poll(), graph, path);
        }
        
        path.addFirst(start);
     }
}
