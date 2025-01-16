class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();

        int max = 0;
        for(int i : candies){
            max = Math.max(i, max);
        }
        for(int i : candies){
            int check = i + extraCandies;
            if(check < max){
                ans.add(false);
            }else{
                ans.add(true);
            }
        }

        return ans;
    }
}