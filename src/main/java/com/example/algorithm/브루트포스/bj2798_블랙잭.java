package com.example.algorithm.브루트포스;

import java.io.*;
import java.util.StringTokenizer;

public class bj2798_블랙잭 {
    static int N;
    static int M;
    static int max;
    static int sum;
    static int[] cardList;
    static int[] usedList;

    public static void main(String args[]) throws IOException{
        //N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.
        //첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다
        //NC3 n개의 카드에서 중복없이 3개를 뽑은 후 다 더한 값이 M을 넘지 않고 최대한 가까운 값을 구한다.
        //중복X, 순서X n개의 카드중 3개 선택 해서 합계 구하기
        input();
        recursion_function(1);
        output();
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cardList = new int[N+1];
        usedList = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++){
            cardList[i] = Integer.parseInt(st.nextToken());
        }

    }
    static void recursion_function(int K){
        if(K == 4){
            // 3개의 카드를 모두 탐색하면 최댓값 갱신
            if(sum <= M){
                if(sum >= max){
                    max = sum;
                }
            }
        }else{
            //전체 배열 중에서 중복없이 3개 선택해서 합을 구함.
            for(int i=1; i<=N; i++) { //전체 카드 배열을 돌면서 3개를 선택함.
                if (usedList[i] == 0) { //선택 안된 카드일 경우에만 선택하기.
                    usedList[i] = 1; //카드 사용
                    sum += cardList[i]; //합계 누적
                    recursion_function(K + 1); //다음 카드 고르기
                    usedList[i] = 0; //사용 제거
                    sum -= cardList[i]; //합계 빼기.
                }
            }
        }
    }
    static void output(){
        System.out.println(max);
    }

}
