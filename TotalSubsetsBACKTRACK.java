import java.util.*;
public class TotalSubsetsBACKTRACK {
    
    static List<List<Integer>> ans=new ArrayList<>();
    
    static void solve(int[] nums,int index,List<Integer> current){
        if(index==nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        solve(nums,index+1,current);
        current.remove(current.size()-1);
        solve(nums,index+1,current);
    }
    
    public static void main(String[] args) {
        int nums[]={1,2,3};
        solve(nums,0,new ArrayList<>());
        System.out.println(ans);
    }
}