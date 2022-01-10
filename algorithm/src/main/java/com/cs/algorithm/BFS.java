package com.cs.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
*  8 9
*  0 1
*  1 2
*  1 3
*  1 4
*  3 7
*  0 5
*  5 4
*  5 6
*  4 7
*
* */

public class BFS {
    private static int shortestDistance=-1; // 탐색 불가.
    private static String path ="";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 정점의 개수
        int m = sc.nextInt(); // 에지의 개수

        ArrayList<Integer>[] adjList = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        bfsByList(adjList,0,1);

        System.out.println(path);
        System.out.println(shortestDistance);
    }

    public static void bfsByList(ArrayList<Integer>[] adjList, int start, int end) {
        int[] distance = new int[adjList.length];

        boolean visited[] = new boolean[adjList.length];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()){
            start = queue.poll();
            path+=start;
            if(start == end) {
                shortestDistance = distance[start];
                break;
            }


            for(int i=0;i<adjList[start].size();i++){
                int w= adjList[start].get(i);
                if(!visited[w]){
                    visited[w] = true;
                    distance[w] = distance[start]+1;
                    queue.add(w);
                }

            }
        }

        queue.clear();
        return;
    }


}
