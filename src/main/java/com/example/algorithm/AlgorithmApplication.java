package com.example.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String args[]) throws IOException {
        input();
        System.out.println(recursion_function(N));
    }

    static int N;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //n번째 피보나치수
    }

    static int recursion_function(int K){

        if(K == 0 || K == 1) {
            return K;
        }else{
            return recursion_function(K-1) +recursion_function(K-2);
        }

    }


}
