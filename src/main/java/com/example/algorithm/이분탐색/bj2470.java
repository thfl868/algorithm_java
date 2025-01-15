package com.example.algorithm.이분탐색;
import java.util.*;
import java.io.*;
public class bj2470 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st =  new StringTokenizer(br.readLine());
        for(int i=0; i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int idx1 =-1;
        int idx2 = -1;

        for(int i=0;i<n-1;i++){
            //용액1 선택
            int t1 = arr[i];

            //용액2 후보 이분탐색으로 찾기.
            int l = i+1;
            int r = n-1;
            int m ;
            int minV = Integer.MAX_VALUE;
            int rt2 = 0;
            while(l<=r){
                m = (l+r)/2;
                int t2 = arr[m];

                //1+2
                int result = t1+t2;
                int abs = Math.abs(result);
                if(abs < minV){
                    minV = Math.min(minV, abs);
                    rt2 = t2;
                }
                if(result<0 ){ //음수라면 t2를 더 오른쪽으로 옮기기.
                    l=m+1;
                }else if(result > 0){
                    r=m-1;
                }else{
                    break;
                }

            }

            //전체중에 최소값 찾기.
            if(min > minV){
                min = Math.min(min,minV);
                idx1 = t1;
                idx2 = rt2;
            }
        }

        System.out.println(idx1 +" "+idx2);
    }
}
