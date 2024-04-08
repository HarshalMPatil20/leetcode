class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int count_0=0;
        int count_1=0;
        for(int i=0;i<students.length;i++){
            if(students[i]==0) count_0++;
            else count_1++;
        }
        int i=0;
        while(count_0>=0 && count_1>=0 && i<sandwiches.length){
            if(sandwiches[i]==0) count_0--;
            else{count_1--;}
            i++;
        }

        // if(i==sandwiches.length) return 0;
        // return sandwiches.length-i+1;
        if( count_0<0) return count_1;
        return count_0; 
        
    }
}