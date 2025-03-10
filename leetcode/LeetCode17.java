class Solution {
    List<String> answer = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        Map<Character, Character[]> graph = new HashMap<>();

        if (digits.length() == 0) {
            return answer;
        }

        graph.put('2', new Character[]{'a', 'b', 'c'});
        graph.put('3', new Character[]{'d', 'e', 'f'});
        graph.put('4', new Character[]{'g', 'h', 'i'});
        graph.put('5', new Character[]{'j', 'k', 'l'});
        graph.put('6', new Character[]{'m', 'n', 'o'});
        graph.put('7', new Character[]{'p', 'q', 'r', 's'});
        graph.put('8', new Character[]{'t', 'u', 'v'});
        graph.put('9', new Character[]{'w', 'x', 'y', 'z'});

        dfs(graph, new StringBuilder(), digits, 0);
        return answer;
    }

    public void dfs(Map<Character, Character[]> graph, StringBuilder path, String digits, int index) {

        if (path.length() == digits.length()) {
            answer.add(path.toString());
            return;
        }

        for (Character c : graph.get(digits.charAt(index))) {
            dfs(graph, new StringBuilder(path).append(c), digits, index + 1);
        }
    } 
}
