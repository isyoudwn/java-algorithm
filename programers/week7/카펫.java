import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int x = 0;
        int y = 0;
        
        for (int[] size : sizes) {
            int xTemp = Math.max(size[0], size[1]);
            int yTemp = Math.min(size[0], size[1]);
            
            if (xTemp > x) {
                x = xTemp;
            }
            if (yTemp > y) {
                y = yTemp;
            }
        }
        
        answer = x * y;
        
        return answer;
    }
}
