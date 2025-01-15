package com.example.algorithm.그래프_dfs_bfs;

import java.util.*;
import java.io.*;

public class bj1260 {
    public static int N,M,V;
    public static List<Integer>[] list;
    public static boolean[] visited;
    public static  StringBuilder sb;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        sb = new StringBuilder();

        //dfs로 끝까지 가보기
        for(int i=1;i<=N;i++){
            list[i] = new ArrayList<>();
        }


        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }


        for(int i=1;i<=N;i++){
            Collections.sort(list[i]);
        }
        visited = new boolean[N+1];
        dfs(V);
        sb.append("\n");

        visited = new boolean[N+1];
        for(int i=0;i<N+1;i++){
            visited[i] = false;
        }
        bfs(V);

        System.out.println(sb);
    }
    public static void dfs(int v){
        visited[v] = true;

        sb.append(v+" ");

        for(int i : list[v]){
            if(visited[i]) continue;
            dfs(i);

        }

    }
    public static void bfs(int v){

        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;

        while(!q.isEmpty()){
            int tmp = q.poll();
            sb.append(tmp+" ");
            for(int i : list[tmp]){
                if(visited[i]) continue;
                visited[i] = true;
                q.offer(i);
            }

        }

    }
}
