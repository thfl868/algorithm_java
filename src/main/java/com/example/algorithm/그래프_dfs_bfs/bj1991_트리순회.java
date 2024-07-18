package com.example.algorithm.그래프_dfs_bfs;
import java.io.*;
import java.util.*;
public class bj1991_트리순회 {
    /**
     * 문제 : 이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal),
     *       후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.
     * 첫째 줄에는 이진 트리의 노드의 개수 N(1 ≤ N ≤ 26)이 주어진다.
     * 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다.
     * 노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 자식 노드가 없는 경우에는 .으로 표현한다.
     *
     * 트리 만드는 법 !!
     * 먼저 root 노드를 만들고 삽입.
     * */
    //todo 트리 만드는법, 전위, 중위, 후위 순회 하는 방법 다시 보기
    public static void main (String[] args) throws IOException{
        input();
        preorder(head);
        System.out.println();
        inorder(head);
        System.out.println();
        postorder(head);
    }
    static  Node head;
    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        head = new Node( 'A', null,null);

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            insertNode(head, root, left, right);

        }
    }

    static void insertNode(Node tmp , char root, char left, char right){
        if(tmp.root == root){
            tmp.left = '.' == left ?null:new Node(left,null, null);
            tmp.right = '.' == right ?null:new Node(right,null, null);
        }else{
            if(tmp.left != null){
                insertNode(tmp.left, root, left, right);
            }
            if(tmp.right != null){
                insertNode(tmp.right, root, left, right);
            }
        }
    }

    public static void inorder(Node node){
        if(node != null){
            inorder(node.left);
            System.out.print(node.root);
            inorder(node.right);
        }
    }
    public static void preorder(Node node){
        if(node != null){
            System.out.print(node.root);
            preorder(node.left);
            preorder(node.right);
        }
    }
    public static void postorder(Node node){
        if(node != null){
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.root);
        }
    }

    static class Node{
        char root ;
        Node left;
        Node right;

        public Node (char root, Node left, Node right){
            this.left = left;
            this.root = root;
            this.right = right;
        }
    }
}
