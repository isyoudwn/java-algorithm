import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        Map<String, ArrayDeque<String>> recordMap = new HashMap<>();
        Map<String, Integer> feeMap = new HashMap<>();

        for (String record : records) {
            String[] temp = record.split(" ");
            recordMap.put(temp[1], new ArrayDeque<>());
        }
        
        for (String record : records) {
            String[] temp = record.split(" ");
            ArrayDeque<String> t = recordMap.get(temp[1]);
            t.add(temp[0]);
            recordMap.put(temp[1], t);
        }
        
        String[] keys = recordMap.keySet().stream().toArray(String[]::new);
        
        Arrays.sort(keys, (a, b) -> a.compareTo(b));
        
        for (String key : keys) {
            ArrayDeque<String> times = recordMap.get(key);
            int time = 0;
            while (!times.isEmpty()) {
                String[] a = times.removeFirst().split(":");
                int aTime = Integer.parseInt(a[0]);
                int aMinute = Integer.parseInt(a[1]);
                
                if (!times.isEmpty()) {
                    String[] b = times.removeFirst().split(":");
                    int bTime = Integer.parseInt(b[0]);
                    int bMinute = Integer.parseInt(b[1]);
                    
                    if (bMinute < aMinute) {
                        bTime = bTime - 1;
                        bMinute = bMinute + 60;
                    }
                    
                    time = time + (bTime - aTime) * 60 + Math.abs(bMinute - aMinute);
                }
                else {
                    time = time + (23 - aTime) * 60 + Math.abs(59 - aMinute);
                }
            }
            feeMap.put(key, time); 
        }
        
        for (String key : keys) {
            int time = feeMap.get(key);
            if (time <= basicTime) {
                answer.add(basicFee);
            } 
            else {
                answer.add(basicFee + (int) Math.ceil((time - basicTime) / (double) unitTime) * unitFee);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
}
}
