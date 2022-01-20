package com.cs.datastructure.stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class StackTest {

    @Test
    void stackPractice(){
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.add(5);

        System.out.println(stack.search(5));
        System.out.println(stack.size()); // 5출
        System.out.println(stack.peek()); // 5 출력

        while(!stack.empty()){ // isEmpty()도 가능
            System.out.println(stack.pop()); // 5, 4, 3, 2, 1 출력
        }
       // stack.pop(); // EmptyStackException...
    }
}
