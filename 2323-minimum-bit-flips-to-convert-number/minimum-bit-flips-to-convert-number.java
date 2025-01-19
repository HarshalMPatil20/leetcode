class Solution {
    public int minBitFlips(int start, int goal) {

        String xor_num = Integer.toBinaryString(start ^ goal);
        int ans=0;

        for(int i=0;i<xor_num.length();i++){
            if(xor_num.charAt(i)=='1') ans++;
        }

        return ans;
        
    }
}