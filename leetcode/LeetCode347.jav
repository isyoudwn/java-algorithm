class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 1) + 1);
        }
        
        Integer[] keys = map.keySet().toArray(Integer[]::new);
        Arrays.sort(keys, (a, b) -> Integer.compare(map.get(b), map.get(a)));

        for (Integer key : keys) {
            if (answer.size() == k) {
                break;
            }
            answer.add(key);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
