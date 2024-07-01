package com.example.algorithm.재귀함수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10870_피보나치수열 {

    static int N;
    static int[] fibonacciNumbers = new int[21];

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //n번째 피보나치수
        fibonacciNumbers[0] = 0;
        fibonacciNumbers[1] = 1;
    }

    public void recursion_function(int K){

        if(K == 0 || K == 1) {
            output(K);
        }else if(K == N){
            output(K);
        }else{
            fibonacciNumbers[K] = fibonacciNumbers[K-1] +fibonacciNumbers[K-2];
            recursion_function(K+1);
        }

    }


    public void output(int n){
        System.out.println(fibonacciNumbers[n]);
    }
}
