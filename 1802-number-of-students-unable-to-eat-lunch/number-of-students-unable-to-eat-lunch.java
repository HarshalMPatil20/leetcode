class Solution {

    public int countStudents(int[] students, int[] sandwiches) {
        int count_0=0; // count of 0 in students
        int count_1=0; // count of 1 in students

// Generating count numbers from students of 0 & 1
        for(int i=0;i<students.length;i++){
            if(students[i]==0) count_0++;
            else count_1++;
        }

// Iterating through sandwiches at any point when any of numbers from students array is become zero 
//so other sandwitches are of reamaining students as students and sandwiches are of same number
        int i=0;
        while(count_0>=0 && count_1>=0 && i<sandwiches.length){
            if(sandwiches[i]==0) count_0--;
            else{count_1--;}
            i++;
        }

// if count of 0 becmes negative means it sold already so count of 1 are remaining students and vice versa
        if( count_0 < 0) return count_1;
        return count_0; 
        
    }
}