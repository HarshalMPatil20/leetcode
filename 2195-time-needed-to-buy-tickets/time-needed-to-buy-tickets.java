class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

// Targeted Element already stored because we are going to change values in array
        int element=tickets[k];

// Subtracted the targeted element from every element of array
        for(int i=0;i<tickets.length;i++){
            tickets[i]-=element;
        }
// positive variable stores number of positive and 0 element after the targeted element becomes zero
// Because according to question we have to stop time counter after targeted element becomes 0 hence we have to subtract counter of extra element whichb we have considered in multiplication
        int positive_elements=0;

// negative counter stores the addition of all extra iterated element even after they becomes 0
        int negative_counters=0;

// LOOP - for determining the number of positive and 0 elements after targted element excluding targted element index
        for(int i=k+1;i<tickets.length;i++){
            if(tickets[i]>=0)  positive_elements++;
        }

// LOOP - For aggregating all negative counters which are extra counted due to direct subtraction of targrted element from that element
        for(int i=0;i<tickets.length;i++){
            if(tickets[i]<0) negative_counters += tickets[i];
        }

// CALCULATION - Total number of iterations of targeted element in worst case + all negative elements counters (plus because the negative_counters is alredy negative in sign) - extra iterated element even after nullification of targeted element
        return (element*tickets.length) + negative_counters - positive_elements;
        
    }
}