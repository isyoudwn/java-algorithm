import java.util.*;

class Solution {
    int[] parent;
    
    public int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x != y) parent[y] = x;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, Comparator.comparing((int[] cost) -> cost[2]));
        
        for (int[] cost : costs) {
            int from = cost[0];
            int to = cost[1];
            int weight = cost[2];
            
            if (find(from) != find(to)) {
                union(from, to);
                answer += weight;
            }
        }
        
        return answer;
    }
}