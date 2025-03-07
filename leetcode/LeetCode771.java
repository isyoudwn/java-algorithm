class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> counter = new HashMap<>();
        int answer = 0;
        
        for (int i = 0; i < jewels.length(); i++) {
            counter.put(jewels.charAt(i), 0);
        }

        for (int i = 0; i < stones.length(); i++) {
            if (counter.containsKey(stones.charAt(i))) {
                answer++;
            }
        }
        return answer;
    }
}