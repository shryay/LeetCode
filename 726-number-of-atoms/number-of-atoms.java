class Solution {
    public String countOfAtoms(String formula) {
        int n = formula.length();
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        int i = 0;
        while (i < n) {
            char ch = formula.charAt(i);
            if (ch == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (ch == ')') {
                Map<String, Integer> top = stack.pop();
                i++;
                int start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int multiplicity = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                for (String key : top.keySet()) {
                    int count = top.get(key);
                    stack.peek().put(key, stack.peek().getOrDefault(key, 0) + count * multiplicity);
                }
            } else {
                int start = i;
                i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) i++;
                String name = formula.substring(start, i);
                start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int multiplicity = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + multiplicity);
            }
        }
        Map<String, Integer> resultMap = stack.pop();
        TreeMap<String, Integer> sortedMap = new TreeMap<>(resultMap);
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            result.append(entry.getKey());
            if (entry.getValue() > 1) result.append(entry.getValue());
        }
        return result.toString();
    }
}