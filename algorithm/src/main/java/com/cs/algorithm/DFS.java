package com.cs.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

/*input example
* n m (8, 10)
* 0 1
* 1 2
* 1 3
* 3 2
* 1 4
* 4 7
* 3 7
* 0 5
* 5 4
* 5 6
* */

public class DFS {
    private static int shortestDistance=-1; // 탐색 불가.
    private static String path ="";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 정점의 개수
        int m = sc.nextInt(); // 에지의 개수

        int[][] adjMatrix = new int[n][n];// 인접행렬 0으로 초기화
        ArrayList<Integer>[] adjList = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adjMatrix[v1][v2] = 1;
//in case of undirected graph adjMatrix[v2][v1] = 1;
            adjList[v1].add(v2);
//in case of undirected graph list[v2].add(v1);
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            visited[i] = false; // 미방문 초기화
        }

        dfsByList(adjList,visited,0,7,0);
        System.out.println(path);
        System.out.println(shortestDistance);
    }

    public static void dfsByMatrix(int adjMatrix[][], boolean[] visited, int start, int end,int distance){
        //인접행렬 구현
        visited[start] = true;
        path += start;


        if(start == end){ // 탐색 성공
            if(shortestDistance == -1) // 첫 번째 탐색일 경우 갱신
                shortestDistance = distance;
            else
                /* 첫 번째 탐색이 아닐 경우
                 * 1) 현재 최단 거리가 distance보다 크면 최단 거리 갱신
                 * 2) 현재 최단 거리가 distance보다 작으면 현재 최단 거리 유지.
                 */
                shortestDistance = shortestDistance > distance ? distance : shortestDistance;
            return;

        }


        for(int w = 0; w<adjMatrix.length; w++){
            if(adjMatrix[start][w] == 1 && !visited[w]){
                dfsByMatrix(adjMatrix,visited,w,end,distance+1);
            }
        }
        return; // 탐색 불가
    }

    public static void dfsByList(ArrayList<Integer>[] arrayLists, boolean[] visited, int start, int end, int distance){
        //인접 리스트 구현
        visited[start] = true;
        path+=start;

        if(start == end){ // 탐색 성공
            if(shortestDistance == -1) // 첫 번째 탐색일 경우 갱신
                shortestDistance = distance;
            else
                /* 첫 번째 탐색이 아닐 경우
                 * 1) 현재 최단 거리가 distance보다 크면 최단 거리 갱신
                 * 2) 현재 최단 거리가 distance보다 작으면 현재 최단 거리 유지.
                 */
                shortestDistance = shortestDistance > distance ? distance : shortestDistance;
            return;
        }

        for (int w : arrayLists[start]) {
            if(!visited[w])
                dfsByList(arrayLists, visited, w, end, distance+1);
        }

        return; //탐색 불가
    }
}
