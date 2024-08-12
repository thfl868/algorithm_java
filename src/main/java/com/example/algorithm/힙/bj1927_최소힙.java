package com.example.algorithm.힙;
import java.io.*;
import java.util.*;

public class bj1927_최소힙 {
    public static void main(String args[]) throws IOException{


        /**최소 힙(Min Heap)
        부모 키값이 자식 노드 키값보다 작은 힙
        최소 힙이란 부모 노드의 값은 항상 자식 노드보다 작거나 같을 때를 의미합니다.
        즉 , 루트 노드 = 트리의 최솟값입니다

         시간 복잡도
         삽입에 있어서는 O(log2n) 의 시간 복잡도를 갖고, 삭제 역시 O(log2n)

         우선순위 큐를 이용하여 최소힙을 구현
         Queue에 들어있는 자료 중 우선순위를 설정하여 우선순위가 높은 순서대로 poll()

         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue pq = new PriorityQueue();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            int node = Integer.parseInt(br.readLine());
            if(node == 0) {
                if(pq.isEmpty()) {
                    System.out.println("0"); //비어있을 경우
                }
                else {
                    System.out.println( pq.poll());
                }
            }else{
                pq.offer(node);
            }
        }

    }
}
