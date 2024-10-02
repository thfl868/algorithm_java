package com.example.algorithm.브루트포스;
import java.io.*;
import java.util.*;
public class bj14501_퇴사 {
    public static int n, max;
    public static List<int[]> list;
    public static int[] T,P;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        T = new int[n];
        P = new int[n];
        for(int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            T[i] = t;
            P[i] = p;
        }
        max = Integer.MIN_VALUE;

        for(int i=0; i<n;i++){
            rec(i, 0);
        }
        System.out.println(max);

    }

    public static void rec(int day,int pay){
        // 종료 조건
        if(day>=n){ //퇴사날짜 이상이면 종료.
            max = Math.max(max,pay);
        }else{
            //상담하기 상담 날짜 + t[day]가 n보다 작을때만 가능
            if(day+T[day] <= n){
                rec(day+T[day], pay+P[day]);
            }
            //상담 안하기.
            rec(day+1, pay);
        }

    }
}
