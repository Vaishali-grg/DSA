package stack;
import java.util.Stack;

public class DailyTemperaturesLC739 {
  
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                int pDay=st.pop();
                ans[pDay]=i-pDay;
            }
            st.push(i);
        }
        return ans;
        
    }
}