package com.example.algorithm.브루트포스;

import java.io.*;
import java.util.*;

public class bj6603_로또_재귀 {
    /**
     * 예를 들어, k=8, S={1,2,3,5,8,13,21,34}인 경우 이 집합 S에서 수를 고를 수 있는 경우의 수는 총 28가지이다.
     * ([1,2,3,5,8,13], [1,2,3,5,8,21], [1,2,3,5,8,34], [1,2,3,5,13,21], ..., [3,5,8,13,21,34])
     * 집합 S와 k가 주어졌을 때, 수를 고르는 모든 방법을 구하는 프로그램을 작성하시오.
     *
     * 재귀함수 이용.
     * 순서 상관 없이 6개 조합 뽑기 , 오름차순으로 출력하기.
     * -> 중복 데이터 제거 및 오름차순 정렬을 위해 for문 시작 인덱스를 i+1로 설정해줘야함!!
     * 입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 한 줄로 이루어져 있다.
     * 첫 번째 수는 k (6 < k < 13)이고, 다음 k개 수는 집합 S에 포함되는 수이다. S의 원소는 오름차순으로 주어진다.
     *
     *
     * */

    static int[] list;
    static int k;
    static boolean[] visited;
    public static void main(String args[]) throws IOException {
        input();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        while(true){
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;
            list = new int[k+1];
            visited = new boolean[k+1];
            for(int i=1; i<= k; i++){
                list[i] =  Integer.parseInt(st.nextToken());
            }
            StringBuilder sb =  new StringBuilder();
            rec_func(1,1, sb);
            System.out.println(sb);
        }
    }

    static void rec_func(int x, int start, StringBuilder sb){
        if(x == 7) {
            for(int i=1; i<=k;i++){
                if(visited[i])
                sb.append(list[i]+" ");
            }
            sb.append("\n");
        }else{
            for(int i=start; i<=k; i++){
                if(!visited[i]){
                    visited[i] = true;
                    rec_func(x+1, i+1, sb);
                    visited[i] = false;
                }
            }
        }

    }

}
