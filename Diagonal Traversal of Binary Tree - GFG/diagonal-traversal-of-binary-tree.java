// { Driver Code Starts
//Initial Template for Java

//Contributed by Sudarshan Sharma
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
class GfG {
    
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
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        Tree g = new Tree();
			    ArrayList<Integer> diagonalNode = g.diagonal(root);
			    for(int i = 0 ;i<diagonalNode.size();i++){
			        System.out.print(diagonalNode.get(i)+ " ");
			    }
		        System.out.println();
	        }
	}
}


// } Driver Code Ends


//User function Template for Java

/* Node is defined as
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}*/
class Tree
{
     static int maxDiagonal = 0 ; 
     public static void dTraversal(Node root , int diagonal ,HashMap<Integer ,ArrayList<Integer>> map){
        if(root == null) return ;
        
        if(diagonal > maxDiagonal){
            maxDiagonal = diagonal;
        }
        
         if(map.containsKey(diagonal) == false){
            map.put(diagonal, new ArrayList<>());
            map.get(diagonal).add(root.data);
        } else {
            map.get(diagonal).add(root.data);
        }
        
        dTraversal(root.left , diagonal + 1 , map);
        dTraversal(root.right , diagonal , map);
     }
    
     public ArrayList<Integer> diagonal(Node root)
      {
           HashMap<Integer ,ArrayList<Integer>> map = new HashMap<>();
           dTraversal(root , 0 , map);
           
           ArrayList<Integer> ans = new ArrayList<>();
           
           for(int d=0 ; d<=maxDiagonal ; d++){
               ArrayList<Integer> list = map.get(d);
               if(list == null) continue;
               for(int item : list){
                   ans.add(item);
               }
           }
           
           return ans;
      }
}
