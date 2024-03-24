class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
 
        // 1st collision 
        // do while loop because slow and fast pointer are starting from same position
        // So if we use while loop , while checks condition first and then executes it
        // so it gets false on the first place without running loop

        do {
            slow = nums[slow];
            fast = nums[nums[fast]]; 
        } while(slow!=fast); 
        
        // reset fast pointer
        fast = nums[0];

        // 2nd collision (fast pointer have same speed as slow pointer)
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
        // or you can return fast pointer as they are at same position
    }
}