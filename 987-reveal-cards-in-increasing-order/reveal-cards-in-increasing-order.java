class Solution {


// Function to find next empty space ( leaving an empty space in between )

    public int Find_next_empty_space(int[] arr,int Current_position){
        int i = Current_position; 
        int Mod_2=0;

        while(true){
            if(arr[i % arr.length]==0) Mod_2++;
            if(Mod_2 % 2==0 && Mod_2!=0) return i % arr.length;
            i++;
        }

    }

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        int [] ans = new int [deck.length];
        int Current_position=1;

// first element will be same for both and according to our first ekement from deck will be get placed in 2nd position in ans which will be wrong hence....
    ans[0]=deck[0];

// placing every element one by one in ans array from deck

    for(int i=1;i<deck.length;i++){
        Current_position=Find_next_empty_space(ans,Current_position);
        ans[Current_position]=deck[i];
    }

      return ans;  
    }
}