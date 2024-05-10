#include <vector>
#include <queue>

class Solution {
public:
    std::vector<int> kthSmallestPrimeFraction(std::vector<int>& arr, int k) {
        // Alias for pair of ints for easier readability
        using Pair = std::pair<int, int>;

        // Custom comparator for the priority queue that will compare fractions
        auto compare = [&](const Pair& a, const Pair& b) {
            return arr[a.first] * arr[b.second] > arr[a.second] * arr[b.first];
        };

        // Define a priority queue with the custom comparator
        std::priority_queue<Pair, std::vector<Pair>, decltype(compare)> pq(compare);

        // Initialize the priority queue with fractions {0, i} (0 < i)
        for (int i = 1; i < arr.size(); ++i) {
            pq.push({0, i});
        }

        // Pop k-1 elements from the priority queue to reach the k-th smallest fraction
        for (int i = 1; i < k; ++i) {
            Pair fraction = pq.top();
            pq.pop();
            if (fraction.first + 1 < fraction.second) {
                // If we can construct a new fraction with a bigger numerator
                pq.push({fraction.first + 1, fraction.second});
            }
        }

        // The top of the priority queue is now our k-th smallest fraction
        // Return the values from `arr` corresponding to the indices of this fraction.
        return {arr[pq.top().first], arr[pq.top().second]};
    }
};