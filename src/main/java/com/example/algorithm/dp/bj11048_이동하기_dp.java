package com.example.algorithm.dp;
import java.io.*;
import java.util.*;
public class bj11048_이동하기_dp {
    /**
     * (1,1) 에서 (N,M)까지 해당 칸의 (r,c+1) ,(r+1,c), (r+1,c+1) 으로 이동하여 사탕을 가져올 수 있는 최대값 구하기
     * dfs 로 풀면 시간초과, dp로 풀어야함!!
     * dfs 시간 복잡도 DFS의 시간 복잡도는 최악의 경우 O(3^(N+M))에 이를 수 있습니다.
     * 이 문제는 최적의 경로를 찾는 문제로, 모든 경로를 탐색하는 것보다 최적의 해를 찾는 것이 더 효율적입니다.
     * DFS는 최적의 해를 보장하지 않기 때문에, 동적 프로그래밍과 같은 다른 접근 방식이 더 적합합니다.
     *
     * */

    static int N,M,max;
    static int[][] arr ;
    static int[][] dp ;
    static boolean[][] visited ;
    static int[][] move = {{0,1},{1,0},{1,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        dp = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken()); //초기화
            }
        }
        max = Integer.MIN_VALUE;
       // dfs(1,1,arr[1][1]);

        dp[1][1] = arr[1][1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                int max = Math.max(dp[i-1][j],dp[i][j-1]);
                max = Math.max(dp[i-1][j-1],max);
                dp[i][j] = arr[i][j]+ max;
            }
        }


        System.out.print(dp[N][M]);
    }
    public static void dfs(int x, int y, int cnt){

        if(x == N && y == M) {
            //최댓값 갱신
            max = Math.max(max,cnt);

        }else {
            //아닌경우 이동해보기
            for (int[] m : move) {
                int nx = m[0] + x;
                int ny = m[1] + y;
                if (nx <= N && ny <= M) { //범위 내
                    if (!visited[nx][ny]) { //미방문
                        visited[nx][ny] = true;
                        dfs(nx, ny, cnt + arr[nx][ny]); //방문
                        visited[nx][ny] = false;
                    }
                }
            }
        }
    }
}
