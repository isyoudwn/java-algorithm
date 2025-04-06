import java.util.*;
import java.io.*;

class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, List<Integer>> graph = new HashMap<>();


        int n = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            Integer a = Integer.parseInt(temp.nextToken());
            Integer b = Integer.parseInt(temp.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        Integer[] keys = graph.keySet().toArray(Integer[]::new);

        for (int key : keys) {
            graph.get(key).sort(Comparator.naturalOrder());
        }

        Set<Integer> dfsPath = new HashSet<>();
        Set<Integer> bfsPath = new HashSet<>();

        dfs(start, graph, dfsPath);
        sb.append("\n");
        bfs(start, graph, bfsPath);

        System.out.print(sb);
    }

    public static void dfs(int now, Map<Integer, List<Integer>> graph, Set<Integer> dfsPath) {
        dfsPath.add(now);
        sb.append(now).append(" ");
        for (int node : graph.get(now)) {
            if (dfsPath.contains(node)) {
                continue;
            }
            dfs(node, graph, dfsPath);
        }
    }

    public static void bfs(int start, Map<Integer, List<Integer>> graph, Set<Integer> bfsPath) {
        Deque<Integer> deque = new ArrayDeque<>();
        bfsPath.add(start);
        deque.add(start);

        while (!deque.isEmpty()) {
            int now = deque.removeFirst();
            sb.append(now).append(" ");

            for (int next : graph.get(now)) {
                if (bfsPath.contains(next)) {
                    continue;
                }
                deque.add(next);
                bfsPath.add(next);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
