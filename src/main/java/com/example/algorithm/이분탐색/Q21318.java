package com.example.algorithm.이분탐색;
import java.util.*;
import java.io.*;
public class Q21318 {
    public static int  n,q;
    public static void main(String args[]) throws IOException {
        /**
         * 첫 번째 줄에 악보의 개수 N(1 ≤ N ≤ 100,000)이 주어진다.
         *
         * 두 번째 줄에 1번 악보부터 N번 악보까지의 난이도가 공백을 구분으로 주어진다.
         *
         * 세 번째 줄에 질문의 개수 Q(1 ≤ Q ≤ 100,000)이 주어진다.
         *
         * 다음 Q개의 줄에 각 줄마다 두 개의 정수 x, y(1 ≤ x ≤ y ≤ N)가 주어진다.*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+2];
        int[] result = new int[n+2];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=n; i++){
            result[i] = result[i-1];
            if(arr[i]>arr[i+1]){
                result[i] += 1;
            }
        }
        q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<q;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int s = 0,e = 0;
            if(a==b) {
                sb.append("0").append("\n");
                continue;
            }
            if(b-1 >= 1){
                s = result[b-1];
            }
            if(a-1 >=1){
                e = result[a-1];
            }
            int r = s-e;
            sb.append(r).append("\n");
        }

        System.out.println(sb);

    }
}
