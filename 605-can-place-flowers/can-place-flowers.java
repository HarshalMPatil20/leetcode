class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int max_plant = 0;

        if(flowerbed.length==1 && flowerbed[0]==0){
            max_plant=1;
            return (n<=max_plant)? true : false;
        }

        if(flowerbed[0]==0 && flowerbed[1]!=1){
                flowerbed[0]=1;
                max_plant++;
        }
        if(flowerbed[flowerbed.length-1]==0 && flowerbed[flowerbed.length-2]!=1) {
                flowerbed[flowerbed.length-1]=1;
                max_plant++;
        }
        for(int i=1;i<flowerbed.length-1;i++){
            if(flowerbed[i]==0 && (flowerbed[i-1]==0 && flowerbed[i+1]==0)){
                flowerbed[i]=1;
                max_plant++;
            }
        }


        return (n<=max_plant)? true : false;
    }
}