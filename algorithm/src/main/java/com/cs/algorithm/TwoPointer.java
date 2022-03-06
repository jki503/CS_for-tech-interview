package com.cs.algorithm;

public class TwoPointer {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,2,5,4,1,1,2};

        int n = arr.length;
        int result = 5;

        // 1. result가 나오는 경우의 수
        // 2.
        int cnt = 0;

        int start = 0;
        int end = 0;
        int sum = 0;

        int range = arr.length + 1;
        int tempStart = 0;

        while(end < n){

            if(sum >= result)
                sum-= arr[tempStart++];
            else
                sum+= arr[end++];

            if(sum == result) {

                // 범위 갱신
                if(range >= end - tempStart) {
                    range = end - tempStart;
                    start = tempStart;
                }
                cnt++;
            }
        }

        System.out.println(cnt); // 1번
        System.out.println("범위 = " + range + ", start = " + start + ", end = " + (start - 1 + range) ); // 2번

    }
}
