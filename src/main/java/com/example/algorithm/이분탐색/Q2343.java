package com.example.algorithm.이분탐색;
import java.io.*;
import java.util.*;
public class Q2343 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int minIdx = 0;
        int maxIdx = 0;
        int[] arr =  new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            minIdx = Math.max(minIdx,arr[i]);
            maxIdx += arr[i];
        }

        System.out.println(binarySearch(arr, minIdx, maxIdx, m));
    }

    public static int binarySearch(int[] arr, int left, int right, int targetCnt){

        while(left<=right){
            int mid = (left+right)/2;
            int sum = 0;
            int count = 1;
            for(int i=0; i<arr.length;i++){
                sum += arr[i];
                if(sum > mid){
                    sum = arr[i];
                    count++;
                }
            }
            if(count > targetCnt){
                left = mid+1;
            }else{
                right = mid-1;
            }

        }
        return left;
    }
}
