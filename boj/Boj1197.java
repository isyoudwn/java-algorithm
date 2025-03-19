import java.io.*;
import java.util.*;

class Main {
    public static int[] parent;
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int[][] costs = new int[E][3];
        parent = new int[V];

        // graph-setting
        for (int i = 0; i < E; i++) {
            StringTokenizer t = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(t.nextToken());
            int v = Integer.parseInt(t.nextToken());
            int w = Integer.parseInt(t.nextToken());

            costs[i][0] = u;
            costs[i][1] = v;
            costs[i][2] = w;
        }

        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, Comparator.comparing((int[] a) -> a[2]));
        System.out.println(kruskal(costs));
    }

    public static int kruskal(int[][] costs) {
        int totalWeight = 0;

        for (int[] cost : costs) {
            int u = cost[0];
            int v =cost[1];
            int w = cost[2];

            totalWeight += union(u - 1, v - 1, w);
        }

        return totalWeight;
    }

    public static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    public static int union(int x, int y, int weight) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;

            return weight;
        }

        return 0;
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
