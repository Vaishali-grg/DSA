package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC0078_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        backTrack(nums, ans, 0, result);
        return result;
    }

    void backTrack(int[] nums, List<Integer> ans, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[index]);
        backTrack(nums, ans, index + 1, result);
        ans.remove(ans.size() - 1);
        backTrack(nums, ans, index + 1, result);
    }

    public static void main(String[] args) {
        LC0078_Subsets solver = new LC0078_Subsets();
        int[] nums = {1, 2, 3};
        System.out.println(solver.subsets(nums));
    }
}