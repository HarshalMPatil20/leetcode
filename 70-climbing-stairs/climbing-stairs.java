class Solution {
    public int climbStairs(int n) {
        
        if(n==1) return 1;
        if(n==2) return 2;
        int t1 = 1;
        int t2 = 2;
        int t3 = 0;
        for(int i=0;i<n-2;i++){
            t3 = t1 + t2;
            t1=t2;
            t2=t3; 
        }
        
        return t3;


        
    }
}