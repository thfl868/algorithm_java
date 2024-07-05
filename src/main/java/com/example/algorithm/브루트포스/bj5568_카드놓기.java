package com.example.algorithm.브루트포스;

import java.util.*;
public class bj5568_카드놓기 {
    static int n,k;
    static int[] cards;
    static int[] selected_cards;
    static StringBuilder sb ;
    static Set<String> set ;
    static boolean[] used;
    public static void main(String args[]){
        input();
        rec_func(1);

        System.out.println(set);
        System.out.println(set.size());
    }
     static void input(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        cards = new int[n+1];
        selected_cards = new int[k+1];
        used = new boolean[n+1];
        set = new HashSet<>();
        for(int i=1; i<=n; i++){
            cards[i] = sc.nextInt();
        }
    }

    //n개의 카드중 k개를 선택해서 숫자 만들기( n개의 카드는 중복된 숫자의 카드도 있을 수 있음!)
    // 그냥 만들고 바로 갯수 카운트 하면 동일한 숫자가 만들어져도 카운트 더해짐. 중복된 숫자는 안세도록 해야함.
    // arrayList or hashset 으로 구현해서 넣을때마다 존재하는지 체크 하고 넣기! (hashset이 contains 더빠름)
    // nCk 최대 10C4 = 최대 210가지 가능.
    //
    static void rec_func(int selected){
        //다 선택하면 존재여부 체크 후 set에 넣기
        if(selected == k+1){
            sb = new StringBuilder();
            for(int i=1; i<=k; i++){
                sb.append(selected_cards[i]);
            }

            if(!set.contains(sb.toString())) {
                set.add(sb.toString());
            }

        }else{ //카드 선택하기.(중복x)
            for(int i=1; i<= n; i++){ //전체중에서 선택해야함.
                if(!used[i]) {//사용 여부 체크
                    selected_cards[selected] = cards[i]; //카드 선택
                    used[i] = true; //사용
                    rec_func(selected + 1);
                    used[i] = false; //카드 사용 초기화
                    selected_cards[selected] = 0; //선택 카드 초기화
                }
            }
        }
    }
}
