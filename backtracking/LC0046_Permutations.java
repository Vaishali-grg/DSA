package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC0046_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backTrack(nums, visited, ans, result);
        return result;
    }

    void backTrack(int[] nums, boolean[] visited, List<Integer> ans, List<List<Integer>> result) {
        if (ans.size() == nums.length) {
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ans.add(nums[i]);
                backTrack(nums, visited, ans, result);
                ans.remove(ans.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        LC0046_Permutations solver = new LC0046_Permutations();
        int[] nums = {1, 2, 3};
        System.out.println(solver.permute(nums));
    }
}