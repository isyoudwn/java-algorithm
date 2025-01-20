import java.util.stream.*;
import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        
        // userId 기준으로 맨 끝에 action을 담는다 -> 닉네임 fix.
        // 그것을 기준으로 map을 만들어서 change는 출력 x 나가고 들어오는것만 출력하도록한다.
        
        Map<String, String> userLog = new HashMap<>();
        
        for (int i = record.length - 1; i >= 0; i--) {
            String[] logLine = record[i].split(" ");
            String command = logLine[0];
            String userId = logLine[1];
            
            if (!command.equals("Leave")) {
                String nickname = logLine[2];
                if (!userLog.containsKey(userId)) {
                    userLog.put(userId, nickname);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (String r : record) {
            String[] logLine = r.split(" ");
            String command = logLine[0];
            String userId = logLine[1];
            
            sb.setLength(0);
            
            if (command.equals("Enter")) {
                String nickname = userLog.get(userId);
                sb.append(nickname);
                sb.append("님이 들어왔습니다.");
                answer.add(sb.toString());
            }
            
            if (command.equals("Leave")) {
                String nickname = userLog.get(userId);
                sb.append(nickname);
                sb.append("님이 나갔습니다.");
                answer.add(sb.toString());
            }
        }
        
        return answer.stream().toArray(String[]::new);
    }
}
