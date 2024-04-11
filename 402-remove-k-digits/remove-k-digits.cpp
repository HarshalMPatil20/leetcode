class Solution {
public:
    string removeKdigits(string num, int k) {
        string res;
    int n = num.length(), keep = n - k;
    for (char c : num) {
        while (k && !res.empty() && res.back() > c) {
            res.pop_back();
            --k;
        }
        res.push_back(c);
    }
    res.resize(keep);
    while (!res.empty() && res[0] == '0') res.erase(res.begin());
    return res.empty() ? "0" : res;
        
    }
};