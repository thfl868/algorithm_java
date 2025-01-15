package com.example.algorithm.이분탐색;
import java.io.*;
import java.util.*;

public class Q2776 {
    public static StringBuffer sb = new StringBuffer();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T;t++) {
            int N = Integer.parseInt(br.readLine());
            int[] test1 = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                test1[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(test1);
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] test2 = new int[M];

            for (int i = 0; i < M; i++) {
                test2[i] = Integer.parseInt(st.nextToken());
                sb.append(find(test2[i], test1)).append("\n");
            }
        }

        System.out.println(sb);

    }
    public static int find(int num, int[] test1){
        int l = 0;
        int r = test1.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            int test1Mid = test1[mid];
            if(test1Mid< num){
                l = mid+1;
            }else if(test1Mid > num){
                r = mid-1;
            }else if(test1Mid == num){
                return 1;
            }
        }

        return 0;
    }
}
