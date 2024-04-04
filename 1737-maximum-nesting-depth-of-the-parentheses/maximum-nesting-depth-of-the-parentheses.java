class Solution {
    public int maxDepth(String s) {
        
        int balance=0;
        int maximum=0;
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='(')balance++;
            if(s.charAt(i)==')') balance--;
             maximum=Math.max(maximum,balance);
        }

        if(balance !=0) return -1;
        else return maximum;
        
        
    }
}