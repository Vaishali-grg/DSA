import java.util.*;
public class CombinationSumLc39 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;

        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private static void helper(int[] nums, int remain, int start, List<Integer> curr, List<List<Integer>> res) {
        if (remain == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] > remain) break; 
            curr.add(nums[i]);
            helper(nums, remain - nums[i], i, curr, res);
            curr.remove(curr.size() - 1); 
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates,target));
    }
}