package com.example.algorithm.그래프_dfs_bfs;

import java.util.*;
import java.io.*;
public class Q1697_2 {
    public static int n, k;
    public static int[] visited;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        visited = new int[100001];
        Arrays.fill(visited,-1);
        bfs(n);
        System.out.println(visited[k]);

    }

    public static void bfs(int a){

        Queue<Integer> que = new LinkedList<>();
        que.offer(a);
        visited[a] = 0;
        while(!que.isEmpty()){
            int q = que.poll();
            if(q == k) break;
            int one = q+1;
            if(check(one) && visited[one] == -1 ){
                visited[one] = visited[q]+1;
                que.offer(one);
            }
            int two = q-1;
            if(check(two) && visited[two] == -1){
                visited[two] = visited[q]+1;
                que.offer(two);
            }
            int three = q*2;
            if(check(three) && visited[three] == -1){
                visited[three] = visited[q]+1;
                que.offer(three);
            }
        }
    }
    public static boolean check(int num){
        if(num >= 0 && num < 100001){
           return true;
        }else {
            return false;
        }
    }

}
