class Solution {
    private List<List<Integer>> combinations = new ArrayList<>();
    private List<Integer> combination = new ArrayList<>();
    private int[] sortedCandidates;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        sortedCandidates = candidates;
        backtrack(0, target);
        return combinations;
    }
    private void backtrack(int startIndex, int remainingSum) {
        if (remainingSum == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        if (startIndex >= sortedCandidates.length || remainingSum < sortedCandidates[startIndex]) {
            return;
        }
        for (int i = startIndex; i < sortedCandidates.length; ++i) {
            if (i > startIndex && sortedCandidates[i] == sortedCandidates[i - 1]) {
                continue;
            }
            combination.add(sortedCandidates[i]);
            backtrack(i + 1, remainingSum - sortedCandidates[i]);
            combination.remove(combination.size() - 1);
        }
    }
}