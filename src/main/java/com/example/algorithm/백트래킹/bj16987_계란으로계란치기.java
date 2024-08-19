package com.example.algorithm.백트래킹;
import java.io.*;
import java.util.*;
public class bj16987_계란으로계란치기 {
    public static void main (String args[])throws IOException {
        input();
        find(0,0);
        System.out.println(max);
    }
    static List<Egg> arr;
    static int n;
    static int max;
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); //계란의 총 갯수
        arr = new ArrayList<>();
        max = 0;

        for(int i=0; i<n; i++){
            String[] a = br.readLine().split(" ");
            int d = Integer.parseInt(a[0]);
            int w = Integer.parseInt(a[1]);
            arr.add(new Egg(d,w)); //배열에 넣기
        }
    }

    static void find(int now , int cnt){
        //최댓값 갱신
        if(max<cnt) max = cnt;

        //경우의 수를 전부 체크해보며 최댓값 찾기.
        // 맨끝까지 가면 끝
        if(now == n) return;
        //손에 들고있는 계란이 깨졌으면 하나 옆에 계란 집기
        if(arr.get(now).durability <=0) {
            find(now+1, cnt);
            return;
        }


        //계란 모든 경우의 수로 깨트려보기
        for(int i=0; i<n; i++){

            if(now == i || arr.get(i).durability <=0) continue; //같은 계란이거나 다음 계란이 깨졌다면 continue;

            //깨트리기
            arr.get(now).durability -= arr.get(i).weight;
            arr.get(i).durability -= arr.get(now).weight;

            int n_cnt = cnt; //다음 계란 집을 때 넘겨줄 cnt (현재 계란수 유지되어야해서 새로운 변수로 담기)
            //깨졌다면 갯수세기
            if(arr.get(now).durability <=0) n_cnt++;
            if(arr.get(i).durability <=0) n_cnt++;

            //재귀로 다음 계란 집기
            find(now+1, n_cnt);

            //초기화해주기
            arr.get(now).durability += arr.get(i).weight;
            arr.get(i).durability += arr.get(now).weight;

        }

    }





    static class Egg {
        int durability;
        int weight;

        Egg (int durability, int weight ){
            this.durability = durability;
            this.weight = weight;
        }


    }
}
