class Solution {
    public boolean isPalindrome(int x) {
        int num = x;
        int reversed  = 0;
        while(num>0){
            reversed*=10;
            reversed+=(num%10);
            num /= 10;
        }

        return (x==reversed) ? true : false;
        
    }
}