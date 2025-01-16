class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb1 = new StringBuilder();


        int p1=word1.length();
        int p2=word2.length();
        while(p1!=0 && p2!=0){
            sb1.append(word1.charAt(word1.length()-p1));
            sb1.append(word2.charAt(word2.length()-p2));
            p1--;
            p2--;
        }
        if(p1==0){
            while(p2!=0){
                sb1.append(word2.charAt(word2.length()-p2));
                p2--;
            }
        }
        if(p2==0){
            while(p1!=0){
                sb1.append(word1.charAt(word1.length()-p1));
                p1--;
            }
        }



     return sb1.toString();   
    }
}