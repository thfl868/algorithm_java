package com.example.algorithm.브루트포스;

import java.io.*;
import java.util.StringTokenizer;
public class bj19532_수학은비대면강의입니다_연립방정식 {
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
