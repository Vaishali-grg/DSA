package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0047_PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        Arrays.sort(nums);
        backTrack(nums, visited, ans, result);
        return result;
    }

    void backTrack(int[] nums, boolean[] visited, List<Integer> ans, List<List<Integer>> result) {
        if (nums.length == ans.size()) {
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
                visited[i] = true;
                ans.add(nums[i]);
                backTrack(nums, visited, ans, result);

                ans.remove(ans.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        LC0047_PermutationsII solver = new LC0047_PermutationsII();
        int[] nums = {1, 1, 2};
        System.out.println(solver.permuteUnique(nums));
    }
}