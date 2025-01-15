package com.example.algorithm.구현;
import java.util.*;
import java.io.*;
public class bj2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //초기화
        for(int i=0;i<k;i++){
            sum += arr[i];
        }
        max = Math.max(max,sum);
        for(int i=1;i<n-k+1;i++){

            sum = sum  + arr[i+k-1] - arr[i-1];
            max =Math.max(max,sum);
        }
        System.out.println(max);
    }
}
