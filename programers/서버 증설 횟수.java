import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Map<Integer, Integer> turnOff = new HashMap<>();
        
        for (int i = 0; i < 24; i++) {
            turnOff.put(i, 0);
        }
        
        int runningServer = 0;
        
        for (int i = 0; i < 24; i++) {
            int onLine = players[i];
            // 증설 된 서버 종료
            runningServer = runningServer - turnOff.get(i);
            turnOff.put(i, 0);
            
            int expectedServer = (int) Math.ceil(onLine / m);
            
            if (onLine >= m && expectedServer > runningServer) {
                int addedServer = expectedServer - runningServer;
                // 서버 증설
                runningServer += addedServer;
                
                // 서버 종료 스케줄 생성
                turnOff.put(i + k, turnOff.getOrDefault(i + k, 0) + addedServer);
                
                answer += addedServer;
            }
        }
        
        return answer;
    }
}
