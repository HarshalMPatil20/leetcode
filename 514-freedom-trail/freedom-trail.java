class Solution {
    public int findRotateSteps(String ring, String key) {
        int keyLength = key.length(); // Length of the key (sequence to spell)
        int ringLength = ring.length(); // Length of the ring
        // Create an array of lists to hold the positions of each character 'a'-'z' in the ring
        List<Integer>[] pos = new List[26];
        // Initialize each list in the array
        Arrays.setAll(pos, k -> new ArrayList<>());
        // Fill the positions lists with the indexes of each character in the ring
        for (int i = 0; i < ringLength; ++i) {
            int index = ring.charAt(i) - 'a'; // Convert char to an index 0-25
            pos[index].add(i); // Add this character's ring position to the corresponding list
        }
      
        // Dynamic programming matrix where f[i][j] represents the minimum steps
        // required to spell the key up to i-th character, ending at j-th position on the ring
        int[][] dp = new int[keyLength][ringLength];
        // Initialize the matrix with high values as we are looking for minimum
        for (var row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE / 2); // Use Integer.MAX_VALUE / 2 to avoid overflow
        }
        // Initialize the first row of the dp matrix based on the first character of the key
        for (int j : pos[key.charAt(0) - 'a']) {
            dp[0][j] = Math.min(j, ringLength - j) + 1;
        }
        // Populate the matrix using previously calculated entries
        for (int i = 1; i < keyLength; ++i) {
            for (int j : pos[key.charAt(i) - 'a']) {
                for (int k : pos[key.charAt(i - 1) - 'a']) {
                    // The current state is the minimum of the current state and
                    // possible previous state plus the distance between k and j plus one for the button press
                    dp[i][j] = Math.min(
                        dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), ringLength - Math.abs(j - k)) + 1);
                }
            }
        }
        // Initialize answer to a high value to find the minimum
        int answer = Integer.MAX_VALUE / 2;
        // Iterate through the final characters positions to find the minimum steps required
        for (int j : pos[key.charAt(keyLength - 1) - 'a']) {
            answer = Math.min(answer, dp[keyLength - 1][j]);
        }
        // Return the minimum steps found
        return answer;
    }
}