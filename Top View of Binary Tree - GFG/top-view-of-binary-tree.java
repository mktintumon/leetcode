// { Driver Code Starts
//Initial Template for JAVA

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution ob = new Solution();

                ArrayList<Integer> vec = ob.topView(root);
                for(int x : vec)
                    System.out.print(x + " ");
                System.out.println();
        	
                t--;   
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution
{
    static class Pair{
        Node node;
        int axis = 0;
    }
    
    static ArrayList<Integer> topView(Node root)
    {
        Queue<Pair> qu = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        int leftMostView = 0;
        int rightMostView = 0;
        
        Pair p = new Pair();
        p.node = root;
        p.axis = 0;
        qu.add(p);
        
        while(qu.size() > 0){
            Pair rem = qu.remove();
            
            if (rem.axis < leftMostView) {
                leftMostView = rem.axis;
            }

            if (rem.axis > rightMostView) {
                rightMostView = rem.axis;
            }
            
            if (map.containsKey(rem.axis) == false) {
                map.put(rem.axis, rem.node);
            }

            if (rem.node.left != null) {
                Pair left = new Pair();
                left.node = rem.node.left;
                left.axis = rem.axis - 1;

                qu.add(left);
            }

            if (rem.node.right != null) {
                Pair right = new Pair();
                right.node = rem.node.right;
                right.axis = rem.axis + 1;

                qu.add(right);
            }
            
        }
        
        for (int i = leftMostView; i <= rightMostView; i++) {
            ans.add(map.get(i).data);
        }
        
        return ans;
        
    }
}