package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC49_GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap < String, List<String> > map=new HashMap<>();
        for(String str:strs){
            char[]arr=str.toCharArray();
            Arrays.sort(arr);
            String key=new String(arr);
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args){
        String[] strs={"eat","tea","tan","ate","nat","bat"};
        System.out.println("Grouped Anagrams : "+groupAnagrams(strs));
    }
}
