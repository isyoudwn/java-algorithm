import java.util.*;

class Solution {
    int lengthX = 0;
    int lengthY = 0;
    
    public int solution(String[] maps) {
        lengthX = maps.length;
        lengthY = maps[0].length();
        
        int labberX = 0;
        int labberY = 0;
        
        int startX = 0;
        int startY = 0;
        
        int targetX = 0;
        int targetY = 0;
        
        for (int i = 0; i < maps.length; i++) {
            if (maps[i].indexOf('S') != -1) {
                startX = i;
                startY = maps[i].indexOf('S');
            }
            
            if(maps[i].indexOf('L') != -1) {
                labberX = i;
                labberY = maps[i].indexOf('L');
            }
            
            if(maps[i].indexOf('E') != -1) {
                targetX = i;
                targetY = maps[i].indexOf('E');
            }
        }
        
        int distanceOfLabber = bfs(startX, startY, labberX, labberY, maps);
        int distanceOfExit = bfs(labberX, labberY, targetX, targetY, maps);
        
        if (distanceOfExit == -1 || distanceOfLabber == -1) {
            return -1;
        }
        
        return distanceOfLabber + distanceOfExit;
    }
    
public int bfs(int startX, int startY, int targetX, int targetY, String[] maps) {
    boolean[][] visited = new boolean[maps.length][maps[0].length()];
    int[][] path = new int[maps.length][maps[0].length()];
    
    ArrayDeque<int[]> deque = new ArrayDeque<>();
    
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    int[] t = {startX, startY}; 
    visited[startX][startY] = true;
    
    deque.add(t);

    while (!deque.isEmpty()) {
        int[] now = deque.removeFirst();
        
        if (targetX == now[0] && targetY == now[1]) {
            return path[now[0]][now[1]];
        }
        
        for (int i = 0; i < 4; i++) {
            int nextX = now[0] + dx[i];
            int nextY = now[1] + dy[i];
            
            if (nextX < 0 || nextX >= lengthX || nextY < 0 || nextY >= lengthY) {
                continue;
            }
            
            if (maps[nextX].charAt(nextY) == 'X') {
                continue;
            }
            
            if (visited[nextX][nextY] == false) {
                int[] temp = {nextX, nextY}; 
                visited[nextX][nextY] = true;
                deque.add(temp);
                path[nextX][nextY] = path[now[0]][now[1]] + 1;
            }
        }
    }
    return -1;
}
}
