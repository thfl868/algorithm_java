package com.example.algorithm.그래프_dfs_bfs;
import java.io.*;
import java.util.*;
public class bj7576_토마토 {
    public static int N,M;
    public static int[][] filed;
    public static int[] moveX = {1,-1,0,0};
    public static int[] moveY = {0,0,1,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        filed = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int n = Integer.parseInt(st.nextToken());
                filed[i][j] = n;
            }
        }
        boolean flag = true;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++) {
                if (filed[i][j] == 0) {
                    flag = false;

                }
            }
        }

        if(flag){
            System.out.println("0");
        }else {
            bfs();
        }
        // 없으면 최대값 출력
    }
    static void bfs(){

        PriorityQueue<Tomato> pq = new PriorityQueue<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(filed[i][j] == 1){
                    pq.offer(new Tomato(i,j,0));
                }
            }
        }

        while(!pq.isEmpty()){
            Tomato t = pq.poll();
            int day = t.day+1;
            for(int i=0;i<4;i++){
                int nx = t.x + moveX[i];
                int ny = t.y + moveY[i];
                if(nx >= 0 && nx <N && ny >=0 && ny <M){
                    if(filed[nx][ny] == 0) {
                        filed[nx][ny] = day;
                        pq.offer(new Tomato(nx, ny, day));
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        // 전체중에 0이 남아있으면 -1 출력
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(filed[i][j] == 0) {
                    System.out.println("-1");
                    return;
                }else{
                    max = Math.max(max,filed[i][j]);
                }
            }
        }
        System.out.println(max);
    }


    static class Tomato implements Comparable<Tomato>{
        int x;
        int y;
        int day;
        Tomato(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
        @Override
        public int compareTo(Tomato o) {
            return Integer.compare(this.day, o.day);
        }
    }
}
