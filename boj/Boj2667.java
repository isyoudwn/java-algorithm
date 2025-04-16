import java.util.*;
import java.io.*;

class Main {
    public static void sol() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        char[][] graph = new char[n][n];
        List<Integer> answer = new ArrayList<>();

        // graph 세팅
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = temp.charAt(j);
            }
        }

        // 탐색
        int complex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == '0') {
                    continue;
                }
                complex++;
                graph[i][j] = '0';
                answer.add(dfs(i, j, graph, 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(answer);
        
        sb.append(complex);
        sb.append("\n");

        for (Integer a : answer) {
            sb.append(a);
            sb.append("\n");
        }
        
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    public static int dfs(int nowX, int nowY, char[][] graph, int count) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for (int i = 0; i < 4; i++) {
            int nextX = nowX + dx[i];
            int nextY = nowY + dy[i];
            
            if (nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[0].length) {
                continue;
            }
            if (graph[nextX][nextY] == '0') {
                continue;
            }
            graph[nextX][nextY] = '0';
            count = dfs(nextX, nextY, graph, count + 1);
        }
        
        return count;
    }
    
    public static void main(String[] args) throws Exception {
        sol();
    }
}
