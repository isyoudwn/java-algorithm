import java.util.*;

class Solution {
    int answer = -1;
    public int solution(int k, int[][] dungeons) {
        ArrayDeque<Integer> visited = new ArrayDeque<>();
        backTrack(dungeons, visited, k, 0);
        return answer;
    }
    
    public void backTrack(int[][] dungeons, ArrayDeque<Integer> visited, int k, int count) {
    
        if (count > answer) {
            answer = count;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (k < dungeons[i][0] || visited.contains(i)) {
                continue;
            }
            visited.add(i);
            backTrack(dungeons, visited, k - dungeons[i][1], count + 1);
            visited.removeLast();
        }
    }
}
