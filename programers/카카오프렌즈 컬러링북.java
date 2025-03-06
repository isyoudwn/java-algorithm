import java.util.*;

class Solution {
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;
    int[][] visited;
    
    public int[] solution(int m, int n, int[][] picture) {
        visited = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 0) {
                    continue;
                }
                
                if (visited[i][j] == -1) {
                    continue;
                }
                
                bfs(i, j, picture);
                numberOfArea++;
            }
        }
            
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public void bfs(int startX, int startY, int[][] picture) {
        Deque<int[]> deque = new ArrayDeque<>();
        int areaSize = 1;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // 영역 추가
        
        deque.add(new int[]{startX, startY});
        int color = picture[startX][startY];
        visited[startX][startY] = -1;
        
        while (!deque.isEmpty()) {
            int[] now = deque.removeFirst();
            
            for (int i = 0; i < dx.length; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                
                if ((nextX >= 0 && nextY >= 0 && nextX < picture.length && nextY < picture[0].length) 
                    && (visited[nextX][nextY] != -1)) {
                    
                    if (color == picture[nextX][nextY]) {
                        deque.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = -1;
                        areaSize++;
                    }
                }
            }
        }
        
        if (areaSize > maxSizeOfOneArea) {
            maxSizeOfOneArea = areaSize;
        }
    }
}
