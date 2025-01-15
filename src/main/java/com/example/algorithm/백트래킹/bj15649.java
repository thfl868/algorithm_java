package com.example.algorithm.백트래킹;

import java.io.*;
import java.util.*;
public class bj15649 {
    public static int n, m ;
    public static StringBuilder sb;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

         n = sc.nextInt();
         m = sc.nextInt();
        sb = new StringBuilder();
        int[] result = new int[m+1];
        int[] arr = new int[n+1];
        Arrays.fill(result, -1);
        rec(0, result,arr);
        System.out.println(sb);
    }
    public static void rec(int idx, int[] result, int[] arr){
        if(idx == m){
            //출력하기.
            for(int i=0; i<m;i++){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
        }else{
            //하나씩 돌아가며 넣어보기
            for(int i=1; i<=n;i++){
                if(arr[i] == 1) continue;
                result[idx] = i;
                arr[i] = 1;
                rec(idx+1, result,arr);
                result[idx] = -1;
                arr[i] = 0;
            }

        }
    }
}
