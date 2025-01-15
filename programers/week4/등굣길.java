import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n][m];
        
        // m은 x좌표이고 열이다. n은 y좌표이고 행이다. 따라서, 문제에서의 좌표는 (열 , 행)으로 생각할 것.
        // 행이 1 또는 열이 1인 곳에 웅덩이가 존재한다면, 그 다음에 나오는 것들은 모두 path가 0이다.
        
        for (int row = 1; row < n; row++) {
            for (int col = 1; col < m; col++) {
                map[row][col] = -2;
            }
        }
        
        // base-case setting
        for (int col = 0; col < m; col++) {
                map[0][col] = 1;
        }
        
        for (int row = 0; row < n; row++) {
            map[row][0] = 1;
        }
        
        // puddle setting
        for (int[] p : puddles) {
            int row = p[1]; // 행
            int col = p[0]; // 열
            
            map[row - 1][col - 1] = 0;
            
            if (row == 1) {
                for (int i = col - 1; i < m; i++) {
                    map[0][i] = 0;
                }
            }
            
            if (col == 1) {
                for (int i = row - 1; i < n; i++) {
                    map[i][0] = 0;
                }
            }
        }
                
        for (int row = 1; row < n; row++) {
            for (int col = 1; col < m; col++) {
                if (map[row][col] != 0) {
                map[row][col] = (map[row][col - 1] % 1000000007) + (map[row - 1][col] % 1000000007);
                }
            }
        }
        
        return map[n - 1][m - 1] % 1000000007;
    }
}
