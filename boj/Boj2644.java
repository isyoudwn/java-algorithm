import java.util.*;
import java.lang.*;

class Main {
    public static int result;
    public static void sol() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start =Integer.parseInt(st.nextToken());
        int end =Integer.parseInt(st.nextToken());
        
        int size = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < size; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(s.nextToken());
            int c = Integer.parseInt(s.nextToken());

            graph.putIfAbsent(p, new ArrayList<>());
            graph.putIfAbsent(c, new ArrayList<>());

            graph.get(p).add(c);
            graph.get(c).add(p);
        }

        if (backTrack(start, graph, 0, new ArrayDeque<>(), end)) {
            System.out.print(result);
            return;
        }
        System.out.print(-1);
    }

    public static boolean backTrack(int now, Map<Integer, List<Integer>> graph, int count, Deque<Integer> visited, int target) {
        if (now == target) {
            result = count; 
            return true;
        }
        for (int next : graph.get(now)) {
            if (visited.contains(next)) {
                continue;
            }
            visited.add(next);
            if (backTrack(next, graph, count + 1, visited, target) == true) {
                return true;
            }
            visited.removeLast();
        }
        
        return false;
    }
    
    public static void main(String[] args) throws Exception {
        sol();
    }
}
