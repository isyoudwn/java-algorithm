import java.nio.Buffer;
import java.util.*;
import java.io.*;

class Main {

    public static void solution() throws Exception {
        // graph-setting
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        for (int i = 0; i < E; i++) {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(temp.nextToken());
            int nodeB = Integer.parseInt(temp.nextToken());
            int weight = Integer.parseInt(temp.nextToken());

            graph.putIfAbsent(nodeA, new HashMap<>());
            graph.putIfAbsent(nodeB, new HashMap<>());

            if (graph.get(nodeA).containsKey(nodeB) && graph.get(nodeA).get(nodeB) < weight) {
                continue;
            }
            graph.get(nodeA).put(nodeB, weight);
            graph.get(nodeB).put(nodeA, weight);
        }

        System.out.print(dijk(1, V, graph));
    }

    public static int dijk(int start, int end, Map<Integer, Map<Integer, Integer>> graph) {
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] a) -> a[1]));
        Map<Integer, Integer> destination = new HashMap<>();

        pq.add(new int[]{start, 0});
        destination.put(start, 0);

        while (!pq.isEmpty()) {
            int[] now = pq.remove();
            int nowNode = now[0];
            int nowWeight = now[1];

            if (nowNode == end) {
                return nowWeight;
            }

            destination.put(nowNode, nowWeight);

            Integer[] relatedNode = graph.get(nowNode).keySet().toArray(Integer[]::new);

            for (int nextNode : relatedNode) {
                if (destination.containsKey(nextNode)) {
                    continue;
                }
                pq.add(new int[]{nextNode, nowWeight + graph.get(nowNode).get(nextNode)});
            }
        }

        return destination.get(end);
    }


    public static void main(String[] args) throws Exception {
        solution();
    }
}
