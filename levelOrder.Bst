import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void levelOrder(Node root) 
    {
        int h=height(root);
        for(int i=0;i<=h;i++)
        {
            disp(root,i);
        }
    }
    public static void disp(Node root,int i)
    {
        if(root == null)
        {
            return;
        }
        if(i == 0)
        {
            System.out.print(root.data+" ");
            return;
        }
        else
        {
            disp(root.left,i-1);
            disp(root.right,i-1);
        }
    }
    public static int height(Node root)
    {
        if(root==null)
        return -1;
        int left_height=height(root.left);
        int right_height=height(root.right);

        return (left_height > right_height)?left_height+1:right_height+1;
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }	
}
