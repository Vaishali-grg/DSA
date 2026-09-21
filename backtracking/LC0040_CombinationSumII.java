package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0040_CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, ans, result);
        return result;
    }

    static void backTrack(int[] candidates, int target, int start, List<Integer> ans, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(ans));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            ans.add(candidates[i]);
            backTrack(candidates, target - candidates[i], i + 1, ans, result);
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC0040_CombinationSumII solver = new LC0040_CombinationSumII();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(solver.combinationSum2(candidates, target));
    }
}