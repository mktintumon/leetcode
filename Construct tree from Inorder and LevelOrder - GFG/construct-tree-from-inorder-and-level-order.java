// { Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }    
        public void setLeft(Node left) 
    {
        this.left = left;
    }
  
    public void setRight(Node right) 
    {
        this.right = right;
    }
        
    
}


class ConstructBT
{
    Node root;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        
	        int inord[] = new int[n];
	        int level[] = new int[n];
	        for(int i = 0; i < n; i++)
	            inord[i] = sc.nextInt();
	            
	        for(int i = 0; i < n; i++)
	             level[i] = sc.nextInt();
	             
	        GfG g = new GfG();
	        Node node =  g.buildTree(inord, level);
	        printPreOrder(node);
	        System.out.println();
	        
	        
	    }
    }
    
   static void printPreOrder(Node node)
   {
       if(node == null)
          return;
          
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
   }
}
// } Driver Code Ends


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG
{
    Node buildTree(int inord[], int level[])
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < level.length; i++){
            map.put(level[i], i);
        }

        Node root = helper(inord, map, 0, inord.length - 1);
        return root;
        
    }

    public Node helper(int[] inord, HashMap<Integer, Integer> map, int in_start, int in_end){
        if(in_start > in_end){
            return null;
        }
        
        int minIdx = in_start; // assuming lo of inorder has least index in levelorder
        for(int i = in_start + 1; i <= in_end; i++){
            if(map.get(inord[i]) < map.get(inord[minIdx])){
                minIdx = i;
            }
        }

        Node node = new Node(inord[minIdx]);
        node.left = helper(inord, map, in_start, minIdx - 1);
        node.right = helper(inord, map, minIdx + 1, in_end);

        return node;
    }

    
   
}