package com.cs.algorithm;

public class SlidingWindow {

    public static void main(String[] args) {

        int[] arr = {1,4,7,10,8,6,2,3,9,5};

        int size = 4;

        // 배열에서 연속된 size만큼의 원소의 합 중 최대값과 시작되는 인덱스 구하기.

        //1. 첫번째 size만큼의 합 저장

        int sum = 0;

        for(int i=0;i<size;i++)
             sum += arr[i];

        int max = sum;
        int idx = 0;

        // 2. 반복문으로 탐색
        for(int i=size; i < arr.length; i++){

            // 앞서 있던 시작 원소 빼고, 새로운 원소 더하기
            sum += arr[i] - arr[i-size];

            if(sum > max){
                max = sum;
                idx = i - size + 1;
            }
        }


        // index = 2, max = 31
        System.out.println("index = " + idx + ", max = " + max);
    }

}
