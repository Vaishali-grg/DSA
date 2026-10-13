package stack;
import java.util.Stack;
import java.util.Arrays;

public class NextGreaterElementIILC503 {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            int idx = i % n;
            while (!st.isEmpty() && nums[st.peek()] < nums[idx]) {
                res[st.pop()] = nums[idx];
            }
            if (i < n) {
                st.push(idx);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}