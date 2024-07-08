package com.example.algorithm.브루트포스;

import java.io.*;
import java.util.StringTokenizer;
public class bj19532_수학은비대면강의입니다_연립방정식 {
    /**
     * **1단계) 문제 분석**
     * 문제 분석은 다음 내용을 포함해주세요.
     *
     * 1. 시간복잡도
     * 2. 제약 조건 분석
     *
     * **2단계) 접근 방식**
     * 1. 생각 과정 설명(왜 이 자료구조/알고리즘을 선택했고, 어떻게 해결방법을 생각하게 되었는지 생각이 도달하는 과정을 설명)
     * 2. 고려한 예외 케이스 설명
     *
     * **3단계) 코드 설계**
     * 개인별로 언어가 다를 수 있으므로 코드 자체를 설명하기보단 2단계에서 설명한 아이디어를 어떻게 구현했는지 설명
     * */
     static int a,b,c,d,e,f;
     public static void main(String args[]) throws Exception{
         input();
         boolean flag = false;
         // x, y가 -999~ 999 사이임. 최악의 상황 2000*2000 = 4000000 4*10^6 (10^8미만이므로 가능)
         for(int i =-999; i<1000; i++){
             for(int j=-999; j<1000; j++){
                 if(calculate(i,j)){
                     System.out.println(i +" "+ j);
                     flag = true;
                     break; //찾으면 끝내기
                 }
             }
             if(flag) break; //찾으면 끝내기.
         }
     }
     static void input() throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());
         a = Integer.parseInt( st.nextToken());
         b = Integer.parseInt( st.nextToken());
         c = Integer.parseInt( st.nextToken());
         d = Integer.parseInt( st.nextToken());
         e = Integer.parseInt( st.nextToken());
         f = Integer.parseInt( st.nextToken());
     }
     static boolean calculate(int x, int y){
         //x,y 가 두가지 식을 모두 통과하는 경우에만 true 반환하기
         boolean a_flag ;
         boolean b_flag ;
         if(c == (a*x +b*y)){
             a_flag = true;
         }else{
             return false;
         }
         if(f == (d*x +e*y)){
            b_flag = true;
         }else{
             return false;
         }

         if(a_flag && b_flag){
             return true;
         }
         return false;
     }
}
