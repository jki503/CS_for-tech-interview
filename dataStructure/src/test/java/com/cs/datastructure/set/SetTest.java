package com.cs.datastructure.set;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {

    @Test
    void setPractice(){
        Set<Integer> hSet = new HashSet<>();
        int[] arr = new int[]{1,2,3,5};

        hSet.add(2);
        hSet.add(2);
        hSet.add(1);
        hSet.add(3);
        hSet.add(5);
        hSet.add(4);
        hSet.remove(2);
        hSet.add(null); // null 허용
        System.out.println(hSet.contains(3));// true 출력;
        System.out.println(hSet.size()); //4 출력


        Iterator<Integer> iter = hSet.iterator();

        while(iter.hasNext()){
           System.out.println(iter.next()); // 1 3 4 5 출
        }
        hSet.clear();
        System.out.println(hSet.size()); // 0출력
        System.out.println(hSet.isEmpty()); // true;

    }
}
