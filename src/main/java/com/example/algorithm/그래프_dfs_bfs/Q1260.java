package com.example.algorithm.그래프_dfs_bfs;
import java.io.*;
import java.util.*;
public class Q1260 {
    public static StringBuffer sb = new StringBuffer();
    public static List<List<Integer> >list ;
    public static boolean[] visited  ;
    public static int n,m,k  ;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        for(int i=0; i<=n;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for(int i=1; i<=n;i++){
            Collections.sort(list.get(i));
        }
        visited = new boolean[n+1];
        Arrays.fill(visited, false);
        dfs(k);
        sb.append("\n");
        Arrays.fill(visited, false);

        bfs(k);
        System.out.println(sb);
    }

    public static void dfs(int k ){
        //방문표시
        visited[k] = true;
        sb.append(k).append(" ");

        List a = list.get(k);
        for(int i=0; i<a.size();i++){
            int v = (int) a.get(i);
            if(!visited[v]){
                dfs(v);
            }
        }
    }

    public static void bfs(int k){
        Queue<Integer> que = new LinkedList<>();
        que.offer(k);
        visited[k] = true;
        while(!que.isEmpty()){
            int q = que.poll();
            sb.append(q).append(" ");
            List a = list.get(q);
            for(int i=0; i<a.size();i++){
                int v = (int) a.get(i);
                if(!visited[v]){
                    que.offer(v);
                    visited[v] = true;
                }
            }
        }
    }
}
