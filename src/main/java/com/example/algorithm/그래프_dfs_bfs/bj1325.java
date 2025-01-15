package com.example.algorithm.그래프_dfs_bfs;
import java.util.*;
import java.io.*;
class bj1325 {
    public static int n, m, cnt, max;
    public static ArrayList<Integer>[] list ;
    public static boolean[] visited;
    public static int[] cntArr;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;
        list = new ArrayList [n+1];

        cntArr = new int[n+1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b); //b에서 a로 이동가능.
        }

        //한번에 가장 많이 이동할 수 있는 컴퓨터 번호 찾기. 가장 많이 이동할 수 있는 갯수가 같다면, 오름차순으로 배열하기.
        for(int i=1; i<=n;i++){
            visited = new boolean[n+1];
            visited[i] = true;
            dfs(i);

        }
        int maxHackCount = 0;
        for (int i = 1; i <= n; i++) {
            maxHackCount = Math.max(maxHackCount, cntArr[i]);
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(cntArr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (cntArr[i] == maxHackCount) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
    public static void dfs(int n ){

        //탈출
        for(int v : list[n]){
            if(!visited[v]){ //방문 안했으면

                visited[v] = true; //방문하기.
                cntArr[v]++;
                dfs(v);
            }
        }


    }

}
