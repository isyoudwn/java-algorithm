class Solution {
    public boolean isValid(String s) {
        String[] arr = s.split("");
        Deque<String> deque = new ArrayDeque<>(Arrays.asList(arr));
        Deque<String> stack = new ArrayDeque<>();

        while (!deque.isEmpty()) {
            String top = deque.removeFirst();

            if (stack.isEmpty()) {
                stack.add(top);
            }

            else {
                String last = stack.peekLast();
                
                if (last.equals("(") && top.equals(")")) {
                    stack.removeLast();
                }

                else if (last.equals("{") && top.equals("}")) {
                    stack.removeLast();
                }
                else if (last.equals("[") && top.equals("]")) {
                    stack.removeLast();
                }
                else {
                    stack.add(top);
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }    
}
