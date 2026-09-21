package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC0039_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        backTrack(candidates, target, 0, ans, result);
        return result;
    }

    static void backTrack(int[] candidates, int target, int start, List<Integer> ans, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(ans));
            return;
        }
        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {
            ans.add(candidates[i]);
            backTrack(candidates, target - candidates[i], i, ans, result);
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC0039_CombinationSum solver = new LC0039_CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(solver.combinationSum(candidates, target));
    }
}