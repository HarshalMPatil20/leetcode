class Solution {
    public int Find_next_empty_space(int[] arr,int k){
        int i=k;
        int Mod_2=0;
        while(true){
            if(arr[i % arr.length]==0) Mod_2 ++;
            if(Mod_2 % 2==0 && Mod_2!=0) return i % arr.length;
            i++;
        }

    }

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        int [] ans = new int [deck.length];
        int s=1;

    ans[0]=deck[0];

    for(int i=1;i<deck.length;i++){
        s=Find_next_empty_space(ans,s);
        ans[s]=deck[i];
    }

      return ans;  
    }
}