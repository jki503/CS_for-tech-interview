package com.cs.datastructure.queue;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

    @Test
    void queuePractice(){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.size()); // 2출력

        while(!queue.isEmpty()){
            System.out.println(queue.poll()); // 1 2 3 출력
        }
        System.out.println(queue.peek()); //null 출력
        System.out.println(queue.poll()); // null 출력

//        System.out.println(queue.element()); //NoSuchElementException
//        System.out.println(queue.remove()); //NoSuchElementException
    }
}
