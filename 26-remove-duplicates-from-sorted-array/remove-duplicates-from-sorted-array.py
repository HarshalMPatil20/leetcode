class Solution(object):
    def removeDuplicates(self, nums):
        Lp=0
        Rp=1

        for Rp in range(len(nums)):
            if(nums[Lp]!=nums[Rp]):
                Lp+=1
                nums[Lp]=nums[Rp]
        
        return Lp+1
        