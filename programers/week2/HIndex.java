import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int N = citations.length;
        int hIndex = 0;
        
        Arrays.sort(citations);
        
        for (int i = 0; i < N; i++) {
            // 인용 횟수, 인용 횟수 이상 인용된 논문 개수 중 작은 거 뽑는다. (hIndex 구하기)
            int temp = Math.min(citations[i], N - i);
            
            // 기존 hIndex 보다 현재의 hIndex가 크면 갱신한다
            hIndex = Math.max(hIndex, temp);
        }
        
        return hIndex;
    }
}
