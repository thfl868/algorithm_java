package com.example.algorithm.dp;
import java.io.*;
public class bj2839_설탕배달_dp {
    /**
    * 설탕 N키로를 5키로, 3키로 짜리 설탕 봉지를 최소한으로 선택하여 배달하는 방법
     * 5키로를 최대로 선택하고, 남은 설탕을 3키로로 선택해야함.
     * 1) N이 5의 배수 ->
     * 2) N이 3의 배수 ->
     * 3) N이 5의배수 + 3의 배수 ->
     *
     * 3,5,6, 8, 9, 10, 12, 13,
     *  3:3 ,5:5 ,6:3+3), 8:5+3, 9:3+3+3), 10:(5+5), 12(3+3+3+3), 13: 3(5+5+3)  15: 5+5+5 / 16: 5+5+3+3
     *
     *  3에 3더하기
     *  5에 5허거나 3 더하기.
     *  3또는 5 더해보기..
     *
    * */

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        for(int i=0; i<=n ; i++){
            arr[i] = -1;
        }

        arr[3] = 1;
        if(n >4) {
            arr[5] = 1;

            for (int i = 6; i <= n; i++) {
                if (arr[i - 5] != -1) {
                    arr[i] = arr[i - 5] + 1;
                } else if (arr[i - 3] != -1) {
                    arr[i] = arr[i - 3] + 1;
                }
            }
        }

        System.out.println(arr[n]);



    }



}
