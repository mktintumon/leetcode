class NumArray {
    class Node{
        int start , end , val;
        Node left , right;
    }
    
    Node root;
    public NumArray(int[] nums) {
        root = construct(nums , 0 , nums.length-1);
    }
    
    Node construct(int[] nums , int low , int high){
        if(low == high){
            Node node = new Node();
            node.start = node.end = low;
            node.left = node.right = null;
            node.val = nums[low];
            return node;
        }
        
        Node node = new Node();
        node.start = low;
        node.end = high;
        
        int mid = (low + high) / 2;
        node.left = construct(nums , low , mid);
        node.right = construct(nums , mid+1 , high);
        
        node.val = node.left.val + node.right.val;
        
        return node;
    }

    
    public void update(int index, int val) {
        update(root , index , val);
    }
    
    void update(Node node , int idx , int val){
        if(node.start == node.end){
            node.val = val;
            return;
        }
        
        int mid = (node.start + node.end) / 2;
        if(idx <= mid){
            update(node.left , idx , val);
        }
        else{
            update(node.right , idx , val);
        }
        
        node.val = node.left.val + node.right.val;
    }
    
    public int sumRange(int left, int right) {
        return query(root , left , right);
    }
    
    int query(Node node , int quStart , int quEnd){
        if(node == null || quStart > node.end || quEnd < node.start){
            return 0;
        }
        else if(node.start >= quStart && node.end <= quEnd){
            return node.val;
        }
        else{
            //call both side -> query range is inside segment range
            int leftVal = query(node.left , quStart , quEnd);
            int rightVal = query(node.right , quStart , quEnd);
            return leftVal + rightVal;
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */