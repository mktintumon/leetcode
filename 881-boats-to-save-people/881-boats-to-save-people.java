class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int count = 0;
        int left = 0;
        int right = people.length-1;
        
        while(left <= right){
            // 2 people at a time
            int weight = people[left] + people[right];
            
            if(weight <= limit){
               count++;
               left++;
               right--; 
            }
            else{
                count++;
                right--;
            }
        }
        
        return count;
    }
}