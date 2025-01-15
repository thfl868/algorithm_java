package com.example.algorithm.dp;
import java.io.*;
import java.util.*;

public class bj11053 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        dp[0] = 1 ;
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        int min = Integer.MAX_VALUE;
        for(int i=2;i<=n;i++){
            for(int j=1; j<i;j++){
                if(arr[i] > arr[j] ){
                    dp[i] = Math.max(dp[j]+1, dp[i]);

                }
                min = Math.max(dp[i],min);
            }
        }

        System.out.println(min);
    }
}
