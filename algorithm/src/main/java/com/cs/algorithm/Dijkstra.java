package com.cs.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {

    public static class Node implements Comparable<Node> {
        int num;
        int cost;

        Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        // 최소 비용이 우선순위로
        @Override
        public int compareTo(Node node) {
            return this.cost < node.cost ? -1 : 1;
        }
    }

    public static void main(String[] args) {

        // edge data from - to - cost
        int edge[][] = {
                {1, 2, 2},
                {1, 3, 5},
                {1, 4, 1},
                {2, 3, 3},
                {2, 4, 2},
                {3, 4, 3},
                {3, 5, 1},
                {3, 6, 5},
                {4, 5, 1},
                {5, 6, 2}
        };

        // n : node 개수
        // k : k 이하 cost
        // count : 자신을 제외한 k 이하 cost 개수
        int n = 6;
        int k = 3;
        int count = 0;

        int[] costArr = new int[n + 1];
        Arrays.fill(costArr, Integer.MAX_VALUE); // Infinity로 설정.

        //edge data를 인접리스트로 설정
        ArrayList<Node>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            adjList[i] = new ArrayList<>();

        for (int i = 0; i < edge.length; i++) {
            int from = edge[i][0];
            int to = edge[i][1];
            int cost = edge[i][2];

            adjList[from].add(new Node(to, cost));
            adjList[to].add(new Node(from, cost));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작 노드 설정
        int start = 1;
        costArr[start] = 0;
        pq.add(new Node(1, 0));

        // 다익스트라 알고리즘으로 start로부터 각 노드 최소 비용 갱신
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int currentNum = node.num;
            int currentCost = node.cost;

            // 최소비용 아니면 continue;
            if (costArr[currentNum] < currentCost)
                continue;

            for (int i = 0; i < adjList[currentNum].size(); i++) {

                // 다음 노드 정보 세팅
                int nextNum = adjList[currentNum].get(i).num;
                int nextCost = adjList[currentNum].get(i).cost + currentCost;

                // 최소비용 계산
                if (costArr[nextNum] > nextCost) {
                    costArr[nextNum] = nextCost;
                    pq.add(new Node(nextNum, nextCost));
                }
            }
        }

        // cost 출력 및 k이하 검색.
        for(int i=1;i<=n;i++){
            /*
            Node 1 cost : 0
            Node 2 cost : 2
            Node 3 cost : 3
            Node 4 cost : 1
            Node 5 cost : 2
            Node 6 cost : 4
            출력
            */
            System.out.println("Node " + i + " cost : " + costArr[i]);
            if(costArr[i] <=k)
                count++;
        }

        System.out.println();
        count-=1; // 자기 자신 제외


        // 4 출력
        System.out.println(count);
    }

}
