package com.example.algorithm.그래프_dfs_bfs;

import java.util.*;
public class bj11725_트리의부모찾기_트리_dfs {
    /**
     * 루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
     * 1. 트리를 인접 리스트로 저장하기
     * 2. 정점 x가 parent를 안다면 자신의 자식을 찾을 수 있다.(자식을 안다면 자식의 부모도 알 수 있음)
     * 3. root부터 차례대로 문제 해결해보기(root는 1로 정해져있음)
     * 4. 탐색 알고리즘 bfs/ dfs (트리문제는 dfs로 구현)
     *
     * 7
     * 1 6
     * 6 3
     * 3 5
     * 4 1
     * 2 4
     * 4 7
     * */

    static ArrayList<Integer>[] arr ;
    static int[] parent;
    static StringBuilder sb ;
    public static void main(String args[]){
        input();
        find();
    }

    static void input(){
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        int n = sc.nextInt();
        arr = new ArrayList[n+1];
        parent = new int[n+1]; //트리구조에서 노드 = 간선의개수 -1
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>(); //인접 리스트배열 초기화
        }
        for(int i=1; i<+n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[x].add(y); //방향성 없으므로 양쪽 다 넣기
            arr[y].add(x);
        }
    }
    static void find(){
        //root 는 1이므로 1부터 탐색해서 부모 노드 저장하기.
        dfs(1,-1);
        //한 뿌리로 타고 내려가면서 부모, 자식 확인하려면 dfs 알고리즘 사용
        for(int i=2; i<parent.length; i++){
            sb.append(parent[i]+"\n");
        }
        System.out.println(sb);
    }

    static void dfs(int chd, int par){
        // 다 탐색 한 경우 프린트
        for(int c: arr[chd]){ //하나의 배열에는 해당 노드에 연결되어있는 부모, 자식이 모두 들어있음.
            //입력받은 chd의부모(par)인 경우 건너뛰기
            if(c == par) continue;
            //부모가 아닌 경우 = c는 chd의 자식임. = chd가 c의 부모
            parent[c] = chd;
            dfs(c, chd);
        }
    }
}
