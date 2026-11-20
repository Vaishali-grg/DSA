package hashmap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LC451_SortCharFreq {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        PriorityQueue<Character>pq=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        pq.addAll(map.keySet());
        StringBuilder res=new StringBuilder();
        while(!pq.isEmpty()){
            char ch=pq.poll();
            int freq=map.get(ch);
            for(int i=0;i<freq;i++){
                res.append(ch);
            }
        }
        return res.toString();
        
    }
    public static void main(String[] args){
        LC451_SortCharFreq obj=new LC451_SortCharFreq();
        String s="tree";
        System.out.print("Sorted string : "+obj.frequencySort(s));
    }
}
