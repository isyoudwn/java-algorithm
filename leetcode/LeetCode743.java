class Solution {
    int N;
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        N = n;

        for (int[] time : times) {
            int current = time[0];
            int destination = time[1];
            int weight = time[2];

            graph.putIfAbsent(current, new HashMap<>());
            graph.get(current).put(destination, weight);
        }

        return dijk(k, graph);
    }

    public int dijk(int start, Map<Integer, Map<Integer, Integer>> graph) {
        // 최단 거리 계산
        Map<Integer, Integer> dist = new HashMap<>();
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] a) -> a[1]));

        // 시작노드 삽입
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.remove();
            int node = now[0];
            int weight = now[1];

            if (dist.containsKey(node)) {
                continue;
            }

            // 새로운 node 와 거리 추가
            dist.put(node, weight);

            // 단방향이기 떄문에 그래프에 존재하는 지 확인
            if (!graph.containsKey(node)) {
                continue;
            }

            Integer[] keys = graph.get(node).keySet().stream().toArray(Integer[]::new);
            
            // 해당 노드의 주변 노드로 탐색
            for (Integer key : keys) {
                int temp = weight + graph.get(node).get(key);
                pq.add(new int[]{key, temp});   
            }
        }

        if (dist.size() == N) {
            Integer[] distKeys = dist.keySet().stream().toArray(Integer[]::new);
            Arrays.sort(distKeys, (a, b) -> Integer.compare(dist.get(b), dist.get(a)));
            return dist.get(distKeys[0]);
        }
        return -1;
    }
}
