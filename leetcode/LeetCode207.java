class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] p : prerequisites) {
            int from = p[0];
            int to = p[1];

            graph.put(from, graph.getOrDefault(from, new ArrayList<>()));
            graph.get(from).add(to);
        }

        Integer[] keys = graph.keySet().stream().toArray(Integer[]::new);
        HashSet<Integer> check = new HashSet<>();

        for (Integer key : keys) {
            Deque<Integer> visited = new ArrayDeque<>();
            if (!dfs(key, visited, graph, check)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int from, Deque<Integer> visited, Map<Integer, List<Integer>> graph, HashSet<Integer> check) {
        // 방문했던 곳을 다시 방문해야 된다면 순환이 존재함
        if (visited.contains(from)) {
            return false;
        }

        if (check.contains(from)) {
            return true;
        }
        

        if (graph.containsKey(from)) {
            // 순환이 있는지 탐색 
            visited.add(from);
            check.add(from);
            
            // from 노드에 순환구조가 존재하는 지 탐색
            for (Integer to : graph.get(from))  {
                boolean result = dfs(to, visited, graph, check);
                if (result == false) {
                    return false;
                }
            }
            // 탐색 후 복구
            visited.removeLast();
        }
        
        // 끝까지 잘 왔으면, 순환이 존재하지 않음
        return true;
    }
}
