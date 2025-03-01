class Solution(object):
    def isPalindrome(self, x):
        num=x
        reverse = 0
        while num > 0 :
            reverse *= 10
            reverse += (num%10)
            num /= 10
    
        if reverse==x :
            return True
        else : return False
        