package com.example.algorithm.이분탐색;

import java.util.*;
public class Q1072{
    public static int cnt, N, r, c;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        int length = (int) Math.pow(2,N);
        devide(0,0,length);
        System.out.println(cnt-1);
    }
    public static boolean devide(int x, int y, int l){
        if(l == 2){
            //방문처리
           if( visit(x,y,l)) {
               return true;
           }
        }else{
            if(devide(x, y, l/2)) return true;
            if(devide(x,y+l/2,l/2)) return true;
            if(devide(x+l/2,y,l/2)) return true;
            if(devide(x+l/2,y+l/2,l/2)) return true;

        }
        return false;
    }

    public static boolean visit(int x, int y, int l){
        for(int i=x; i<x+l; i++){
            for(int j=y; j<y+l;j++){
                cnt++;
                if(i==r && j==c){
                    return true;
                }
            }
        }
        return false;
    }

}
