package com.example.algorithm.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2231_분해합 {
    static int n, len, min;

    public static void main(String args[]) throws IOException {
        input();
        rec_func(1);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        n = Integer.parseInt(N);
        min = n;
        len = N.length();
    }

    public static void rec_func(int cnt){
        //자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.
        //245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다.
        //자연수 N(1 ≤ N ≤ 1,000,000)
        //9+9+9+9+9+9 최대 54까지 더해질 수 있음.
        /*
        * 자연수 N이 주어지면 생성자가 되는 수의 자리수를 세고, 해당 자리수만큼 9가 여러번 올 수 있다.
        * 생성자는 N보다 작아야함.
        * 생성자에서 1씩 빼보면서 생성자 만들어보기....
        *
        * */
        //최대 카운트까지 간다면 멈추기
       if(cnt >= 9*len){
           if(min == n){ //생성자 없는 경우 0 반환
               System.out.println("0");
           }else {
               System.out.println(min); //생성자 있는 경우 반환
           }
       }else{
           //분해합 구하기
           int constructor = n-cnt;
           int sum = constructor;
           String cList = String.valueOf(constructor);
           int[] c = new int[cList.length()];
           //String 을 int[]으로 변환하는 법!
           for(int i =0; i<cList.length(); i++){
               sum +=  (cList.charAt(i) - '0');
           }
           if(sum == n){
               if(min >= constructor) { //생성자 최솟값 갱신하기.
                   min = constructor;
               }
           }
            rec_func( cnt+1);
       }
    }
}
