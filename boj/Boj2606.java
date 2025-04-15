import java.util.*;
import java.io.*;

class Main {
    public static Set<Integer> visited = new HashSet<>();

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        Integer v = Integer.parseInt(br.readLine());

        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.putIfAbsent(i + 1, new ArrayList<>());
        }
        
        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer from = Integer.parseInt(st.nextToken());
            Integer to = Integer.parseInt(st.nextToken());

            graph.putIfAbsent(to, new ArrayList<>());
            graph.putIfAbsent(from, new ArrayList<>());

            graph.get(to).add(from);
            graph.get(from).add(to);
        }
        visited.add(1);
        dfs(1, graph);
        System.out.print(visited.size() - 1);
    }

    public static void dfs(int now, Map<Integer, ArrayList<Integer>> graph) {
        for (Integer next : graph.get(now)) {
            if (visited.contains(next)) {
                continue;
            }
            visited.add(next);
            dfs(next, graph);
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
