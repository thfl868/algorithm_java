package com.example.algorithm.dp;
import java.util.*;
public class bj1463_1로만들기 {
    /**
     * 연산을 최소화하여 1로 만들기
     * 1.X가 3으로 나누어 떨어지면, 3으로 나눈다.
     * 2.X가 2로 나누어 떨어지면, 2로 나눈다.
     * 3.1을 뺀다.
     *
     *  i-1과 i/2 i/3 중에서 가장 작은 값+1 로 arr[i] 넣기
     * */

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] arr = new int[x+1];
        arr[1] =0;
        for(int i=2; i<=x; i++){
            //세개 중에 최솟값에서 +1 하기.
           arr[i] =  arr[i-1]+1;
           if(i%2 == 0 ) arr[i] = Math.min(arr[i],arr[i/2]+1);
           if(i%3 == 0 ) arr[i] = Math.min(arr[i],arr[i/3]+1);
        }

        System.out.println(arr[x]);
    }
}
