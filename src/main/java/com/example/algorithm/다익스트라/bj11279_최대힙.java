package com.example.algorithm.다익스트라;
import java.io.*;
import java.util.*;

public class bj11279_최대힙 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue pq = new PriorityQueue(Collections.reverseOrder()); //최대힙
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
