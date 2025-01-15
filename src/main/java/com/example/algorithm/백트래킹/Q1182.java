package com.example.algorithm.백트래킹;
import java.util.*;

public class Q1182 {

    public static  int n,s,cnt;
    public static  int[] arr;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         s = sc.nextInt();

         arr = new int[n];
        for(int i=0; i<n;i++){
           arr[i] = sc.nextInt();
        }

         cnt = 0;

        for(int i=1;i<=n;i++){ //1개 ~ n개까지 선택
            //arr에서 i개 선택해서 다 더한게 s가 되는 개수 구하기
            boolean[] used = new boolean[n];
            Arrays.fill(used,false);
            int[] result = new int[n];
            for( int j = 0; j<n-i; j++){
                find(0, j, i, result, used);

            }

        }
        System.out.println(cnt);

    }
    public static void find(int idx, int k, int i, int[] result, boolean[] used){
        if(idx == i){
            //다 더해서 s 되는지 확인
            int sum = 0;
            for(int j=0;j<i;j++){
                //arr에서 i개 선택해서 다 더한게 s가 되는 개수 구하기
                sum += result[j];
                System.out.println(result[j]);
            }
            if(sum == s) {
                cnt++;
            }

            System.out.println("sum : "+ sum);
            System.out.println();
            return ;
        }else{
            for(int j=k; j<n; j++){
                if(used[j]) continue;
                result[idx] = arr[j];
                used[j] = true;
                find(idx+1, k, i, result, used);
                result[idx] = 0;
            }

        }
    }
}