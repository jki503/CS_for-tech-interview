package com.cs.algorithm;

import java.util.Arrays;

public class Kruskal {

    public static void main(String[] args) {

        int V = 7;
        int[][] E = {
                {1,7,12},
                {5,7,73},
                {4,7,13},
                {3,6,37},
                {2,5,62},
                {3,5,20},
                {5,6,45},
                {1,2,67},
                {2,4,24},
                {1,5,17},
                {1,4,28},
        };
        // cost 기준으로 오름 차순 정렬
        Arrays.sort(E, (e1,e2) -> e1[2] -e2[2]);

        // 부모 노드
        int[] parent = new int[V+1];
        for(int i=1;i<=V;i++)
            parent[i] = i;

        int costSum = 0;
        for (int[] e: E) {

            // 같은 부모면 - cycle 발생이면 continue;
            if(checkCycle(parent,e[0],e[1]))
                continue;
            costSum += e[2];
            unionParent(parent,e[0], e[1]);
            System.out.println("Edge : " +e[0] + " " + e[1]);
        }

        System.out.println(costSum);

    }

    public static boolean checkCycle(int[] p, int e1, int e2){

        e1 = getParent(p,e1);
        e2 = getParent(p,e2);

        return e1 == e2 ? true : false;
    }

    public static int getParent(int[]p, int e){

        if(p[e] == e) return e;
        return getParent(p,p[e]);
    }

    public static void unionParent(int[] p, int e1, int e2){

        e1 = getParent(p,e1);
        e2 = getParent(p,e2);

        // 더 작은 부모로 병합
        if(e1 < e2) p[e2] = e1;
        else p[e1] = e2;
    }

}
