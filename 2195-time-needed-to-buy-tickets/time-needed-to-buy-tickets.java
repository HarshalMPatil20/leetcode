class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

        int element=tickets[k];

        for(int i=0;i<tickets.length;i++){
            tickets[i]-=element;
        }

        int positive=0;
        int negative=0;

        for(int i=k+1;i<tickets.length;i++){
            if(tickets[i]>=0)  positive++;
        }

        for(int i=0;i<tickets.length;i++){
            if(tickets[i]<0) negative += tickets[i];
        }

        return (element*tickets.length)+negative-positive;
        
    }
}