package com.example.algorithm;

import java.util.Scanner;

class Main{
    static int m,n,k,cnt;
    static Cabbage[] cab_list = new Cabbage[4];
    static StringBuilder sb = new StringBuilder();
    static int[][] filed ;
    public static void main(String args[]){
        cab_list[0] = new Cabbage(-1,0);
        cab_list[1] = new Cabbage(1,0);
        cab_list[2] = new Cabbage(0,1);
        cab_list[3] = new Cabbage(0,-1);
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for(int i=0; i<test_case; i++) {
            cnt = 0;
            m = sc.nextInt(); //배추밭 가로
            n = sc.nextInt(); //배주밭 세로
            k = sc.nextInt(); //배추 심어져있는 위치의 개수
            filed = new int[m][n];

            for(int j=0; j<k; j++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                filed[x][y] = 1; //배추밭에 배추 심기
            }
            for(int a=0; a<m; a++){ //(x축)
                for(int b =0; b<n; b++){ //(y축)
                    if(filed[a][b] == 1){
                        dfs(a,b);
                        cnt++;
                    }
                }
            }
            sb.append(cnt+"\n");
        }
        System.out.print(sb);
    }
    void input(){

    }

    static void dfs(int a, int b){

        filed[a][b] = -1; //배추밭 방문

        for(Cabbage c : cab_list){
            int new_x = a+c.getX();
            int new_y = b+c.getY();
            if( new_x>=0 && new_x <m && new_y>=0 && new_y <n){
                if( filed[new_x][new_y] == 1) dfs(new_x, new_y);
            }
        }



    }




     static class Cabbage {
        public int x;
        public int y;

        public Cabbage(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return this.x;
        }

        public int getY(){
            return this.y;
        }
    }

}
