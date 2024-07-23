package com.example.algorithm.그래프_dfs_bfs;
import java.util.*;
import java.io.*;
public class bj2748_피보나수2 {
    /**
     * 숫자 n이 주어지면 n번째의 피보나치 수를 구하는 문제
     *
     * */
    public static void main(String args[]) throws IOException{
        input();
        System.out.print(dfs(n));
    }
    static int n;
    static long[] fibo_list;
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        fibo_list = new long[n+1];
        for(int i=0; i<n; i++){
            fibo_list[n] = 0L;
        }
        fibo_list[0] = 0L;
        fibo_list[1] = 1L;
    }

    static long dfs(int k){
        if(k == 0|| k==1) {
            return fibo_list[k]; //0이나 1인 경우 그냥 반환
        }else if(fibo_list[k] != 0L){
            return fibo_list[k]; //이미 계산했던 피보나치수는 바로 반환
        }else{
            return fibo_list[k] = dfs(k-1) +dfs(k-2); //계산안한 피보나치수는 계산 후 반환
        }
    }
}
