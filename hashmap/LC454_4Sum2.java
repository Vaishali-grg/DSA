package hashmap;

import java.util.HashMap;

public class LC454_4Sum2 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int a:nums1){
            for(int b:nums2){
                int sum=a+b;
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        int count=0;
        for(int c:nums3){
            for(int d:nums4){
                int sum=c+d;
                int tar=-sum;
                count+=map.getOrDefault(tar,0);
            }
        }
        return count;
    }
    public static void main(String[] args){
        LC454_4Sum2 obj=new LC454_4Sum2();
        int[] nums1={1,2};
        int[] nums2={-2,-1};
        int[] nums3={-1,2};
        int[] nums4={0,2};
        System.out.print("Count of tuples : "+obj.fourSumCount(nums1,nums2,nums3,nums4));
    }

}
