package com.example.algorithm.시험;


import java.io.*;
import java.util.*;

public class Q18116 {
    public static int[] arr ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        List<HashSet<Integer>> hash = new ArrayList<>();
        for(int i=1; i<=n;i++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if("I".equals(command)){

            }else{

            }
        }

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
