package com.example.algorithm.dp;
import java.util.*;
import java.lang.*;
import java.io.*;

public class bj9655_돌게임_dp {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            //dfs(n, "SK");
            dp(n);
        }

        /**
         dfs로 풀었으나, dfs로 풀경우 최악 O(2^n)이기 때문에 시간초과 날 수있음
         dp또는 수학적으로 풀어야함.

         *dfs
         n이 0이될때까지 dfs 돌리기
         n이 들어왓을때 상근이부터 -1 또는 -3 돌리기.
         상근이 차례 끝나면 창영이 -1 또는 -3
         //n이 딱 0이 됐을때! 이니셜 출력

         * 수학적
         * n =0 일때 창영이 이김
         * n=1 상근
         * n=2 창영
         * n=3 상근
         * n=4 창영
         * n=5 상근
         * ...
         * 짝수일때: 창영, 홀수일때: 상근
         *
         *
         * dp
         * 완벽하게 게임을 해야하기 때문에 n-1 , n-3 이 모두 창영이면 n은 상근 모두 상근이면 n은 창영
         *
         */
    static boolean flag = false;
    public static void dfs(int n, String name){
        if(flag) return;
        //이번차례 사람 이름 들어옴.
        if(n == 0){
            if("SK".equals(name)){
                System.out.println("CY"); // 전차례 사람 이름 출력해야함
            }else{
                System.out.println("SK"); // 전차례 사람 이름 출력해야함
            }
            flag = true;
        }
        else if(n>0){
            //상근 차례인 경우 -1 또는 -3 하고 창영이 차례
            if("SK".equals(name)){
                dfs(n-1, "CY");
                dfs(n-3, "CY");
            }else{
                dfs(n-1, "SK");
                dfs(n-3, "SK");
            }
        }

    }
    public static void dp(int n){
        boolean[] arr = new boolean[n+1];
        arr[1] = true; //상근 이김
        arr[2] = false; //창영 이김
        arr[3] = true; //상근 이김

        for(int i =4; i<=n; i++){
            if(arr[i-1] && arr[i-3]){ //바로 전에 상근인 경우
                arr[i] = false;
            }else{
                arr[i] = true;
            }
        }

        if(arr[n]) System.out.println("SK");
        else System.out.println("CY");
    }
}
