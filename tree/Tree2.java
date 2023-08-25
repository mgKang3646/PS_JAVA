package org.example.tree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//BOJ5639 이진 검색 트리
public class Tree2 {

    public static class Node{
        int num;
        Node left, right;

        public Node(int num){
            this.num = num;
        }

        //객체 참조 구조를 이용
        public void insert(int value){
            if( value < this.num ){  // ROOT 보다 작으면 LEFT
                if( left == null) {
                    left = new Node(value);
                }else{
                    this.left.insert(value);
                }
            }

            else{ // ROOT 보다 크면 RIGHT
                if( right == null ){
                    right = new Node(value);
                }
                else {
                    this.right.insert(value);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        Node root = new Node(num);

        while(true){
            String input = br.readLine();
            if(input == null || input.equals("")) break;

            root.insert(Integer.parseInt(input));
        }

        postOrder(root);

    }


    public static void postOrder(Node root){
        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.num);
    }
}
