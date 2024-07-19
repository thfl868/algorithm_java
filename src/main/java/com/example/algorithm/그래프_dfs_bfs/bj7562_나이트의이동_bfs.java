package com.example.algorithm.그래프_dfs_bfs;
import java.io.*;
import java.util.*;
public class bj7562_나이트의이동_bfs {
    /**
     * 나이트의 위치가 주어지고, 이동 하려는 위치의 좌표로 이동하려면 몇번 이동해야 하는지 최솟값 구하기
     * bfs로 여러 방향으로 이동해보면서, 원하는 위치에 이동되었을때 cnt 출력하기.
     * 나이트가 갈 수있는곳으로 계속 이동시켜, 원하는 위치일때 멈추고(return으로)
     * 방문했던 곳은 다시 방문 못하도록하기.
     * 이동한 횟수도 같이 que에 넣기
     *
     * */

    public static void main(String args[]) throws IOException{
        input();
        System.out.println(sb.toString());
    }
    static StringBuilder sb;
    static int arr_len;
    static boolean[][] visited;
    static int destination_x;
    static int destination_y;
    static int[] x_list = {-2,-1,1,2,2,1,-1,-2}; //배열 이동 숫자 확인 ^^..
    static int[] y_list = {1,2,2,1,-1,-2,-2,-1};

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        sb = new StringBuilder();
        for(int i=0; i<test_case; i++){
            arr_len = Integer.parseInt(br.readLine());
            visited = new boolean[arr_len][arr_len];
            init_visited();
            st = new StringTokenizer(br.readLine());
            int now_x = Integer.parseInt(st.nextToken());
            int now_y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            destination_x = Integer.parseInt(st.nextToken());
            destination_y = Integer.parseInt(st.nextToken());

            //bfs로 최단거리 찾기
            bfs(now_x, now_y, 0);
            init_visited();
        }
    }

    static void init_visited(){
        for(int j=0; j<arr_len; j++){
            for(int k=0; k<arr_len; k++){
                visited[j][k] = false;
            }
        }
    }
    static void bfs(int x, int y , int cnt){
            Queue<Chess> que = new LinkedList<>();
            que.offer(new Chess(x,y,cnt));
            visited[x][y] = true; //방문
            while(!que.isEmpty()) {
                Chess c = que.poll();
                int now_x = c.getX();
                int now_y = c.getY();
                int now_cnt = c.getCnt();
                //현재 이동한 위치가 목표 위치인경우 bfs 끝내기!
                if (now_x == destination_x && now_y == destination_y) {
                    //System.out.println(now_cnt);
                    sb.append(now_cnt+"\n");
                    return;
                }else {
                    //목표 위치 아닌경우 이동 가능 거리 확인하여 이동하기.
                    for (int i = 0; i < 8; i++) {
                        int new_x = now_x + x_list[i];
                        int new_y = now_y + y_list[i];
                        if (new_x >= 0 && new_x < arr_len && new_y >= 0 && new_y < arr_len) { //이동 가능한곳
                            if (!visited[new_x][new_y]) { //방문 안한곳
                                que.offer(new Chess(new_x, new_y, now_cnt + 1));
                                visited[new_x][new_y] = true;
                            }
                        }
                    }
                }
//            }
        }
    }

    static class Chess{
        int x;
        int y;
        int cnt;
        public Chess(int x , int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
        int getX(){
            return this.x;
        }
        int getY(){
            return this.y;
        }
        int getCnt(){
            return this.cnt;
        }
    }
}
