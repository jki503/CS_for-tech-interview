package com.cs.datastructure.priorityQueue;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    @Test
    void PriorityQueuePractice(){

        // 우선 순위를 낮은 숫자로
        PriorityQueue<Integer> pqLower = new PriorityQueue<>();

        // 우선 순위를 높은 숫자로.
        PriorityQueue<Integer> pqHigher = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=1;i<6;i++){
            pqLower.offer(i);
            pqHigher.offer(i);
        }

        System.out.println("Lower int" + pqLower.poll()); // 1 출력

        while(!pqLower.isEmpty()){
            System.out.println("Lower int" +pqLower.poll()); // 2 3 4 5 출력
        }

        while(!pqHigher.isEmpty()){
            System.out.println(pqHigher.poll()); // 5 4 3 2 1 출력
        }
    }
}
