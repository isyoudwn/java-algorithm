import java.io.*;
import java.util.*;

class Main {

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(br.readLine());
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        int V = Integer.parseInt(info.nextToken());
        int E = Integer.parseInt(info.nextToken());
        int startNode = Integer.parseInt(br.readLine());


        // setting-graph
        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.putIfAbsent(from, new HashMap<>());

            if (graph.get(from).containsKey(to)) {
                if (graph.get(from).get(to) > weight) {
                    graph.get(from).put(to, weight);
                }
            }
            else {
                graph.get(from).put(to, weight);
            }
        }

        Map<Integer, Integer> dest = dijk(startNode, graph);
        result(dest, V);
    }

    public static void result(Map<Integer, Integer> dest, Integer V) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= V; i++) {
            if (dest.containsKey(i)) {
                sb.append(dest.get(i));
            }
            else {
                sb.append("INF");
            }

            if (i != V) {
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }

    public static Map<Integer, Integer> dijk(int start, Map<Integer, Map<Integer, Integer>> graph) {
        Map<Integer, Integer> dest = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] a) -> a[1]));

        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.remove();
            int nowNode = now[0];
            int nowWeight = now[1];

            if (dest.containsKey(nowNode)) {
                continue;
            }

            dest.put(nowNode, nowWeight);

            if (!graph.containsKey(nowNode)) {
                continue;
            }

            Integer [] keys = graph.get(nowNode).keySet().toArray(Integer[]::new);

            for (Integer nextNode : keys) {
                Integer nextWeight = graph.get(nowNode).get(nextNode);
                pq.add(new int[]{nextNode, nowWeight + nextWeight});
            }
        }

        return dest;
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
