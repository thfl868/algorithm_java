package com.example.algorithm.브루트포스;
import java.util.Scanner;
public class bj18312_시각 {
    static int N,K,count;
    static String hh,mm,ss;
    public static void main(String arg[]) {
        input();
        count_clock_3(N,String.valueOf(K));
        System.out.println(count);
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        count = 0;
    }

    //1. 모든 시간을 문자열로 만든 후, count 세기
    static void count_clock_1(int N, String K){
        for(int i=0; i<=N; i++){
            for(int j=0; j<60; j++){
                for(int k=0; k<60; k++){
                    hh = i <10 ? "0"+i : i+"";
                    mm = j <10 ? "0"+j : j+"";
                    ss = k <10 ? "0"+k : k+"";
                    if((hh+mm+ss).contains(K)) count++;
                }
            }
        }
    }


    // 시간, 분, 초 단위로 나눠서 위에서 걸리는 경우 한번에 더하고 넘어가기.
    //00시 00분 00초 ~ N시 59분 59초까지 K가 포함되는 시간 수 카운트
    // 삼중 포문에 i,j,k를 쓰기때문에 헷갈려서 안쓰도록 주의해야함!!
     static void count_clock_2(int N, String K){
        for(int i=0; i<=N; i++){
            if(i < 10) {
                hh = "0" + i;
            } else {
                hh = String.valueOf(i);
            }
            if(hh.contains(K)){
                count += 3600;
                continue;
            }
            for(int j=0; j<60; j++){
                if(j < 10) {
                    mm = "0" + j;
                } else {
                    mm = String.valueOf(j);
                }
                if(mm.contains(K)){
                    count += 60;
                    continue;
                }
                for(int k=0; k<60; k++){
                    if(k < 10) {
                        ss = "0" + k;
                    } else {
                        ss = String.valueOf(k);
                    }
                    if(ss.contains(K)){
                        count++;
                    }
                }
            }
        }
    }

    //시간을 문자열 말고, 숫자 자체에서 10으로 나누거나 나머지를 구하여 요구하는 K의 값이 존재하는지 체크하기
    static void count_clock_3(int N, String K){
        int time = Integer.parseInt(K);
        for(int i=0; i<=N; i++){
            if(i% 10 == time || i/10 ==time) {
                count += 3600;
                continue;
            }
            for(int j=0; j<60; j++){
                if(j% 10 == time || j/10 ==time) {
                    count += 60;
                    continue;
                }
                for(int k=0; k<60; k++){
                    if(k% 10 == time || k/10 ==time) {
                        count++;
                    }
                }
            }
        }
    }

}
