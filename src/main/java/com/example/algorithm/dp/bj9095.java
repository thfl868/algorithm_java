package com.example.algorithm.dp;
import java.io.*;
import java.util.*;
public class bj9095 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for(int j=0;j<k;j++) {
            int n = sc.nextInt();
            int[] arr = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                if (i == 1) {
                    arr[i] = 1;
                } else if (i == 2) {
                    arr[i] = 2;
                } else if (i == 3) {
                    arr[i] = 4;
                } else {
                    arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1];
                }
            }
            System.out.println(arr[n]);
        }
    }
}
