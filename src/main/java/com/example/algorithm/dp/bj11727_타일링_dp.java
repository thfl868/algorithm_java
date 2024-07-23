package com.example.algorithm.dp;
import java.util.*;
import java.lang.*;

public class bj11727_타일링_dp {

        /**
         * 점화식을 잘 세워야함
         * n번째 타일의 경우의 수는
         * (n - 1번째 타일의 경우의 수) + (n - 2번째 타일의 경우의 수의 두 배)
         * */

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            dp(n);
        }


        static void dp(int n){
            int[] arr = new int[n+1];

            arr[1] = 1;
            arr[2] = 3;

            if(n >=3 ) {
                for (int i = 3; i <= n; i++) {
                    arr[i] = (arr[i - 1] + arr[i - 2] * 2) % 10007; // arr에 넣을때부터 10007로 나눈 나머지를 넣어야함!!
                }
            }

            System.out.println(arr[n] );
        }


}
