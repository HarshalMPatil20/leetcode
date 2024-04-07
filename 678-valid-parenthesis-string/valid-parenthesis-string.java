class Solution {

    public boolean checkValidString(String s) {

        //how many min and max open brackets are possible?
        int minOpen = 0;
        int maxOpen = 0;

        for(int i=0; i<s.length(); i++){
            
            char current = s.charAt(i);

            //if c is ), we have closed one open bracket, so reduce minOpen and maxOpen both by 1 
            if(current == ')'){
                minOpen--;
                maxOpen--;
            }

            //if c is (, we have one extra open bracket, so increase minOpen and maxOpen both by 1
            if(current == '('){
                minOpen++;
                maxOpen++;
            }

            //if c is *, it can be empty, open or close
            //the minOpen will reduce by 1 if we consider it as closed
            //the maxOpen will increase by 1 if we consider it as open
            //no change, if we consider it as empty
            if(current == '*'){
                minOpen--;
                maxOpen++;
            }

            if(maxOpen < 0) return false; //Example: ))((

            minOpen = Math.max(0, minOpen); //reset minOpen to 0 as -ve is not possible as min

        }

        //if the minOpen brackets is 0, which means there is a possible equal number of close brackets
        return minOpen == 0;

    }

}