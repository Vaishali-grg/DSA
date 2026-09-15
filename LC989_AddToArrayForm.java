import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayForm {
    class Solution {
        public List<Integer> addToArrayForm(int[] num, int k) {
            List<Integer> list = new ArrayList<>();
            int i = num.length - 1;
            

            while (i >= 0 || k > 0) {
                // Add the current array digit to k
                if (i >= 0) {
                    k += num[i];
                    i--;
                }
                
                // Add the last digit of the sum to our result list
                list.add(k % 10);
                
                // Remove the last digit from k to carry over the rest
                k /= 10;
            }
            
            // Because we added from right to left, the result is backwards. 
            // We must reverse it before returning.
            Collections.reverse(list);
            
            return list;
        }
    }
}
