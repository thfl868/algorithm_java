package com.example.algorithm.이분탐색;
import java.util.*;
import java.io.*;

public class Q2630 {
    public static int[][] arr ;
    public static int blue, white;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[n+1][n+1];
         blue = 0;
         white = 0;
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        devide(1,1,n);
        System.out.println(white);
        System.out.println(blue);

    }

    public static void devide(int x, int y, int l){
        if(isAllBlue(x,y,l)){
            blue++;
        }else if(isAllWhite(x,y,l)){
            white++;
        }else{
            devide(x, y, l/2);
            devide(x,y+l/2,l/2);
            devide(x+l/2,y,l/2);
            devide(x+l/2,y+l/2,l/2);
        }

    }
    public static boolean isAllBlue(int x, int y , int l){
        if(l == 1 && arr[x][y] == 1){
            return true;
        }
        for(int i=x; i<x+l;i++){
            for(int j=y; j<y+l; j++){
                if(arr[i][j] == 0){
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean isAllWhite(int x, int y , int l){
        if(l == 1&& arr[x][y] == 0){
            return true;
        }
        for(int i=x; i<x+l;i++){
            for(int j=y; j<y+l; j++){
                if(arr[i][j] == 1){
                    return false;
                }
            }
        }
        return true;

    }
}
