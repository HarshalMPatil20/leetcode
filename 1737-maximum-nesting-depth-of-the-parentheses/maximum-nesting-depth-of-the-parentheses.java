class Solution {
    public int maxDepth(String s) {
        
        int balance=0;
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='(')balance++;
            if(s.charAt(i)==')') balance--;
        }

        if(balance !=0) return -1;
        else{
            int counter=0;
            int maximum=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='(')counter++;
                if(s.charAt(i)==')') counter--;
                maximum=Math.max(maximum,counter);
            }
            return maximum;
        }
        
    }
}