package com.example.algorithm.dp;
import java.util.*;
import java.io.*;
public class bj12865 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] weight = new int[n+1];
        int[] value = new int[n+1];
        int[][] dp = new int[k+1][n+1];

        //초기화
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            weight[i] =  Integer.parseInt(st.nextToken());
            value[i] =  Integer.parseInt(st.nextToken());
        }
        // 무게 / 가치
        for(int i=1;i<=k;i++){
            for(int j=1;j<=n;j++){
                //현재 넣을 수 있음? 지금 까지의 무게+ value[j] 가
                //지금 넣는거는  [j-1] 의 최댓값 vs [(i-weight)에서 + value] 한것의 최댓값
                if(i-weight[j] >= 0){
                    //todo 중복 방지 위해  dp[i-weight[j]][j-1] 해야함! 현재 거 포함 안한 부분에서부터 비교해야함.
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-weight[j]][j-1]+value[j]);
                }else{
                    dp[i][j] = dp[i][j-1];
                }

                System.out.print(dp[i][j]+" ");
            }

            System.out.println();

        }
        System.out.println(dp[k][n]);
    }
}
