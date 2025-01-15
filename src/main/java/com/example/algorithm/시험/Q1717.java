package com.example.algorithm.시험;

import java.io.*;
import java.util.*;

public class Q1717 {
    public static int[] arr ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=n;i++){
            arr[i] = i;
        }
        for(int i=0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(st.nextToken());
            int b =  Integer.parseInt(st.nextToken());
            int c =  Integer.parseInt(st.nextToken());
            if(a == 0){
                //합집합
                union(b,c);
            }else if(a == 1){
                //같은 집합인지 확인
                sb.append( find(arr[b]) == find(arr[c]) ? "YES" : "NO").append("\n");
            }
        }
        System.out.println(sb);
    }
    public static int find(int x){
        if(arr[x] == x){
            return x;
        }else{
            return arr[x] = find(arr[x]);
        }


    }
    public static void union(int b, int c){
        int B = find(arr[b]);
        int C = find(arr[c]);
        if(B < C){
            arr[c] = B;
        }else{
            arr[b] = C;
        }
    }
}
