import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] memo = new int[triangle.length][];
        int N = triangle.length - 1;
        
        for (int i = 0; i < triangle.length; i++) {
            memo[i] = Arrays.copyOf(triangle[i], triangle[i].length);
            Arrays.fill(memo[i], 0);
        }

        memo[0][0] = triangle[0][0];
        
        for (int i = 0; i < triangle.length - 1; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                memo[i + 1][j] = Math.max(triangle[i + 1][j] + memo[i][j], memo[i + 1][j]);
                memo[i + 1][j + 1] = Math.max(triangle[i + 1][j + 1] + memo[i][j], memo[i + 1][j + 1]);
            }
        }
        
        Integer[] temp = Arrays.stream(memo[N]).boxed().toArray(Integer[]::new);
        Arrays.sort(temp, Comparator.reverseOrder());
        
        return temp[0];
    }
}
