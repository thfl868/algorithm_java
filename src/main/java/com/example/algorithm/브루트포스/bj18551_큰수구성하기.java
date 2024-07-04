package com.example.algorithm.브루트포스;
import java.io.*;
import java.util.StringTokenizer;
public class bj18551_큰수구성하기 {
    //todo 1시간 안에 못품!! 다시 확인해보기
    static int N;
    static int N_length;
    static int K;
    static int[] num_list;
    static int max = 0;
    public static void main(String args[]) throws IOException{
        input();
        getNums(0,0);
        System.out.println(max);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        N_length = n.length();
        N = Integer.parseInt(n);
        K = Integer.parseInt(st.nextToken());
        num_list = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            num_list[i] = Integer.parseInt(st.nextToken());
        }
    }

    //K개중에 N.length개 만큼 중복하여 숫자를 뽑아서 N보다 작은 가장 큰수 만들기.
    //못만들면 N.length-1개만큼 뽑아서 가장 큰 수 만들기
    private static void getNums(int cnt, int num) {
        if (cnt == N_length) {
            return;
        }

        num *= 10;
        if (num >= N)
            return;

        for (int i = 0; i < K; i++) {
            int tmp = num + num_list[i];
            if (tmp > N) continue;
            if (tmp > max) max = tmp;
            getNums(cnt+1, tmp);
        }
    }




}
