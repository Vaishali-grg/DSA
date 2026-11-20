package hashmap;

import java.util.HashMap;

public class HashMapBasics {
    public static void main(String[] args) {
        HashMap<Integer,String>map=new HashMap<>();
        map.put(101,"Ram");
        map.put(101,"Sita");
        map.put(102,"Geeta");
        map.put(103,"Geeta");
        map.put(0,"Geeta");
        map.put(1,"Geeta");
        map.put(2,"Geeta");
        map.put(10,"Geeta");
        System.out.println(map);
        // hashcode() key
        // hashing k through bucket index calculate
        // formula : index=(n-1) &hash
        // n= hashmap capacity
        // default capacity =16
        // key=0 hash=0 bucket_index=0
        //  1       1     1
        //  2       2     2
        // 10      10     10
        // 100     100    4
        // 101     101    5l
        // 102     102    6
        
        
    }
}
