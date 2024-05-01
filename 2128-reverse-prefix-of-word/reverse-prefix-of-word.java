class Solution {
    public String reversePrefix(String word, char ch) {

        int position = -1;
        String str ="";

        for(int i=0;i<word.length();i++){
            str = word.charAt(i) + str;
            if(word.charAt(i)==ch){
                position = i;
                break;
            }
        }


        if(position == -1) return word;

        for(int i=position+1;i<word.length();i++){
            str = str + word.charAt(i);
        }

        return str;



        
    }
}