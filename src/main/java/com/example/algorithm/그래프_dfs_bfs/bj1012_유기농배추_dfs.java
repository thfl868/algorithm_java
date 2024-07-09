package com.example.algorithm.그래프_dfs_bfs;

import java.util.*;
class bj1012_유기농배추_dfs {

    //todo : 1시간 내에 못품! 다시 풀어보기
    //dfs 로 풀어야함!! (dfs, bfs를 언제 쓰는지 차이를 잘 알아야 할 것 같다.
    /**
     * 벌레는 인접한 배추에 이동할 수 있음.
     * 각 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수를 출력한다.
     *
     * 첫째 줄에는 배추를 심은 배추밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50),
     * 그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다. 그 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)가 주어진다.
     *
     * 벌레가 인접한 배추에 갈 수 있음..
     * 전체중에 한 노드에서 갈 수 있는 모든 노드를 방문체크,
     * 더 이상 방문할 곳 없으면 count 늘리고, 다른 노드 가기..
     * 전체 배열 for문 다 돌면 끝
     * */
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
