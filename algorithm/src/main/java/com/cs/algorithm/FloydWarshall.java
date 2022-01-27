package com.cs.algorithm;

public class FloydWarshall {

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

        // n: 노드 개수
        // start : 시작 노드
        int n = 6;
        int start = 3;
        int MAX = Integer.MAX_VALUE;

        // edge 정보 담을 인접행렬 설정
        int costMap[][] = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for(int j=1 ;j<=n; j++)
                costMap[i][j] = MAX;
        }

        for(int i=0;i<edge.length;i++){
            int from = edge[i][0];
            int to = edge[i][1];
            int cost = edge[i][2];

            costMap[from][to] = cost;
            costMap[to][from] = cost;
        }

        // 경유 노드
        for(int k=1;k<=n;k++){
            // 출발 노드
            for (int i = 1; i <= n; i++) {
                // 도착 노드
                for (int j = 1; j <= n; j++) {
                    // 자기 자신 continue;
                    if(i==j)
                        continue;
                    // 해당 경로가 유효하지 않을 경우 continue;
                    if (costMap[i][k] == MAX || costMap[k][j] ==MAX)
                        continue;

                    int  nextCost = costMap[i][k] + costMap[k][j];

                    // 다음 비용이 현재 비용보다 적은지 판단 후 갱신
                    if(costMap[i][j] > nextCost)
                        costMap[i][j] = nextCost;
                }
            }
        }
        // 자기 자신은 0으로
        costMap[start][start] = 0;

        for(int i=1;i<=n;i++)
            System.out.println(start + " Node -> " + i + "Node : " + costMap[start][i]);

    }
}
