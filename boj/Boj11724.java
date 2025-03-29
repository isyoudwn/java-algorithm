import java.util.*;
import java.io.*;

class Main {
    public static Set<Integer> visited = new HashSet<>();

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // NODE 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer temp = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(temp.nextToken());
            int node2 = Integer.parseInt(temp.nextToken());

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        Integer[] keys = graph.keySet().toArray(Integer[]::new);

        for (Integer key : keys) {
            if (visited.contains(key)) {
                continue;
            }
            bfs(key, graph);
            answer++;
        }
        System.out.print(answer);
    }

    public static void bfs(int start, Map<Integer, List<Integer>> graph) {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.add(start);
        visited.add(start);

        while (!deque.isEmpty()) {
            int now = deque.removeFirst();

            for (int next : graph.get(now)) {
                if (visited.contains(next)) {
                    continue;
                }
                deque.add(next);
                visited.add(next);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
