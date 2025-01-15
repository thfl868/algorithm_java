package com.example.algorithm.이분탐색;

import java.io.*;
import java.util.*;

public class Q1654 {
    public static void main(String args[]) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        for(int i=0;i<k;i++){
            arr[i] =Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        System.out.println(find(n,arr));
    }

    public static long find(int n, int[] arr){

        long max = 0;
        long l = 0;
        long r = arr[arr.length-1];

        while(l<=r){
            long mid = (l+r)/2;
            long cnt = 0;
            for(int i=0;i<arr.length;i++){
                cnt += (arr[i] / mid);
            }
            if(cnt<n){
                r = mid-1;
            }else{
                max = Math.max(max,mid);
                l = mid+1;
            }
        }
        return max;


        //이분탐색으로 자르는 길이 선택.

        //자르고 난 다음에 자르는 길이만큼 해당되는 갯수 세기.

        //갯수<n 면 r 줄이기.

        //갯수>=n 면 l 늘리기.

    }
}
