package com.example.algorithm.이분탐색;
import java.io.*;
import java.util.*;
public class Q2470 {
    public static long a, b, min;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for(int i=0;i<n;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        min = Long.MAX_VALUE;

        for(int i=0;i<n-1;i++){
            //이분탐색으로 a와 b의 합이 0에 가장 가깝거나, 0인거 찾기.
            long one = arr[i];
            int left = i+1;
            int right = n-1;
            while(left <= right){
                int mid = (left+right)/2;
                long two = arr[mid];
                long sum = one+two;
                long abs = Math.abs(sum);
                if(abs < min){
                    min = abs;
                    a = one;
                    b = two;
                }

                if(sum < 0){
                    left = mid+1;
                }else if(sum > 0){
                    right = mid-1;
                }else{
                    //찾음.
                    break;
                }
            }


        }
        System.out.println(a + " "+ b);
    }
    public static void binarySearch(int left , int right, long[] arr, long one ){


    }

}
