package com.example.algorithm.브루트포스;
import java.util.*;
public class bj15721_번데기 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); //명
        int t = sc.nextInt(); //구하는 번째
        int b = sc.nextInt(); //0 or 1
        int n = 1;
        int idx = 0; //전체인덱스
        int zeroIdx = 0; //뻔
        int oneIdx = 0; //데기
        while(true){
           StringBuilder sb = new StringBuilder();
           sb.append("0101");
           for(int i=1;i<=n+1;i++){
               sb.append("0");
           }
            for(int i=1;i<=n+1;i++){
                sb.append("1");
            }

            String str = sb.toString();
            for(int i=0;i<str.length();i++){
                idx++;
                if(str.charAt(i) == '0'){ // 뻔
                    zeroIdx++;
                }else if(str.charAt(i) == '1') { // 데기
                    oneIdx++;
                }
                if(b == 0 && zeroIdx == t){ //뻔 구하는 것일때
                    //전체 인덱스에서 인원수로 나눠서 누구인지 구하기.
                    int who = ((idx % a)+(a-1)) % a;
                    System.out.print(who);
                    return ;
                }
                if(b == 1 && oneIdx == t){ //데기 구하는 것일때
                    int who = ((idx % a)+(a-1)) % a;
                    System.out.print(who);
                    return ;
                }
            }

            n++;
        }

    }
}
