package com.cs.algorithm;

public class BinarySearch {

    public static void main(String[] args) {

        // 3 이상 값이 처음 나오는 index = 3 -> LowerBound
        // 3 초과 값이 처음 나오는 index = 5 -> UpperBound
        // size = 11
        // 배열은 정렬되어있다고 가정한다. 정렬된 배열 사용
        int[] arr = {1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6};

        int indexLower = lowerBound(3, arr);
        int indexUpper = upperBound(3, arr);


        System.out.println("Lower Bound index = " + indexLower + ", value= " + arr[indexLower]);
        System.out.println("Upper Bound index = " + indexUpper + ", value= " + arr[indexUpper]);

        // end를 arr.length가 아닌 arr.length-1로 잘못 설정할 경우
        System.out.println(upperBoundEndFault(7, arr));

        // 찾을 수 없다면 return index -1
        System.out.println(lowerBound(7, arr));
        System.out.println(upperBound(7, arr));

        /* 출력 예시

            Lower Bound index = 3, value= 3
            Upper Bound index = 5, value= 4
            10
            -1
            -1
        */
    }

    public static int binarySearch(int num, int[] arr){
        int start = 0;
        int end = arr.length -1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(num == arr[mid]) {
                return mid;
            }
            else if(num < arr[mid]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }

        }

        // 탐색 실패
        return -1;
    }

    // num 이상 값이 처음으로 나오는 index 찾기
    public static int lowerBound(int num, int[] arr) {
        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (arr[mid] >= num) {
                end = mid;
            } else {
                start = mid + 1;
            }

        }

        // 못찾을 경우
        if (start >= arr.length)
            return -1;

        return start;
    }

    // num 초과 값이 처음으로 나오는 index 찾기
    public static int upperBound(int num, int[] arr) {
        int start = 0;
        int end = arr.length;

        while (end > start) {
            int mid = (start + end) / 2;

            if (arr[mid] > num) {
                end = mid;
            } else
                start = mid + 1;
        }

        // 못찾을 경우
        if (start >= arr.length)
            return -1;

        return start;
    }

    public static int upperBoundEndFault(int num, int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (end > start) {
            int mid = (start + end) / 2;

            if (arr[mid] > num) {
                end = mid;
            } else
                start = mid + 1;
        }

        // 못찾을 경우
        if (start >= arr.length)
            return -1;

        return start;
    }

}
