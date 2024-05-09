class Solution {
public:
    long long maximumHappinessSum(vector<int>& happiness, int k) {

        sort(happiness.begin(), happiness.end()); 

        long long ans = 0;

        for(int i=0;i<k;i++){
            long long value = happiness[(happiness.size()-1)-i]-i;
            if(value>=0) {ans = ans + value;}
        }
        
        return ans;
    }
};