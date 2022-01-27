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

    @Test
    void priorityQueueComparablePractice(){

        class Employee implements Comparable<Employee>{

            String name;
            int wage;

            Employee(String name, int wage){
                this.name = name;
                this.wage = wage;
            }

            @Override
            public int compareTo(Employee o) {
                return this.wage < o.wage ? 1 : -1;
            }
        }

        PriorityQueue<Employee> pq = new PriorityQueue<>();

        // 100000, 60000, 50000, 20000 우선순위
        pq.offer(new Employee("Jung",100000));
        pq.offer(new Employee("Na",50000));
        pq.offer(new Employee("Choi",20000));
        pq.offer(new Employee("Park",60000));

        while(!pq.isEmpty()){
            Employee employee = pq.poll();
            String name = employee.name;
            int wage = employee.wage;

            // Jung, Park, Na, Choi 출력
            System.out.println("name : " + name + ", " + "wage : = " + wage);
        }

    }


}
