package com.cs.datastructure.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {

    @Test
    void HashMapPractice(){
        HashMap<String,Integer> map = new HashMap<>();

        map.put("AA",1);
        map.put("BB",2);
        map.put("CC",3);

        // AA의 value가 2로 갱신
        map.put("AA",2);


        // entrySet
        System.out.println("=====EntrySet 반복문 조회=====");
        for (Map.Entry<String,Integer> entry: map.entrySet()){
            System.out.println("[key] : " + entry.getKey() + " [value] : " + entry.getValue());
        }
        System.out.println();

        // keySet
        System.out.println("=====KeySet 반복문 조회=====");
        for(String s : map.keySet()){
            System.out.println("[key] : " + s + " [value] : " + map.get(s));
        }

        System.out.println();

        // iterator
        System.out.println("=====Iterator 조회=====");
        Iterator<String> keys = map.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            System.out.println("[key] : " + key + " [value] : " + map.get(key));
        }

        System.out.println();

        map.remove("CC"); // BB 삭제
        System.out.println(map.get("AA")); // 2
        System.out.println(map.containsKey("b")); // false
        System.out.println(map.containsKey("AA")); // true
        System.out.println(map.containsValue(3)); // false;

    }
}
