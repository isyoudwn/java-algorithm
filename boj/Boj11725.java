import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void sol() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> result = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        int nodeCount = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < nodeCount - 1; i++) {
            st = new StringTokenizer(br.readLine());
            Integer nodeA = Integer.parseInt(st.nextToken());
            Integer nodeB = Integer.parseInt(st.nextToken());
            map.putIfAbsent(nodeA, new ArrayList<>());
            map.putIfAbsent(nodeB, new ArrayList<>());

            map.get(nodeA).add(nodeB);
            map.get(nodeB).add(nodeA);
        }
        deque.add(1);
        visited.add(1);

        while (!deque.isEmpty()) {
            Integer now = deque.removeFirst();
            List<Integer> nodes = map.get(now);
            for (Integer nextNode : nodes) {
                if (!result.containsKey(nextNode)) {
                    result.put(nextNode, now);
                }
                if (visited.contains(nextNode)) {
                    continue;
                }
                visited.add(nextNode);
                deque.add(nextNode);
            }
        }

        List<Integer> keys = new ArrayList<>(result.keySet()).stream().sorted().collect(Collectors.toList());

        for (Integer key : keys) {
            if (key == 1) {
                continue;
            }
            sb.append(result.get(key));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        sol();
    }
}
