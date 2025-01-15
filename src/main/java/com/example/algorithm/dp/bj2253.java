package com.example.algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] a = str.split(" ");
        int arrLength = Integer.parseInt(a[0]);
        int n = Integer.parseInt(a[1]);
        int[] arr = new int[arrLength+1];

        System.out.println(arrLength + " ,"+n);
        for(int i = 1; i <= arrLength; i++){
            arr[i] = 0;
        }

        for(int i=0;i<n;i++){
            int k = Integer.parseInt(br.readLine());
            if(arr[i] == k){
                arr[i] = -1;
            }
        }
        for(int i = 1; i <= arrLength; i++){
            System.out.println(arr[i]);
        }

        int r = 1; //이동칸수
        int cnt = 0;
        int idx = 0;
        while(true){
            if(idx >= arrLength){
                break;
            }

            if( arr[idx+(r+1)] == 0){
                r++;
                cnt++;
                idx = idx+r;
            }else {
                if(arr[idx+r] == 0){
                    cnt++;
                    idx = idx+r;
                }else if(arr[idx+r-1] == 0){
                    r--;
                    cnt++;
                    idx = idx+r;
                }
            }
        }

        // System.out.println(idx==arrLength? cnt:"-1");
    }
}
