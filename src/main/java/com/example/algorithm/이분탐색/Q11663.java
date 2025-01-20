package com.example.algorithm.이분탐색;

import java.io.*;
import java.util.*;
public class Q11663 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for(int i=0; i<n;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            long start =  Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            int a = lowerBound(start, arr);
            int b = upperBound(end, arr);
            System.out.println(b-a);
        }
    }
    public static int lowerBound( long target, long[] arr) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    public static int upperBound( long target, long[] arr) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
