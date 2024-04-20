class Solution {
    public int[] search(int[][] land, int a, int b) {
    int[] arr = new int[4];
    int x = a;
    int y = b;

    // Find the bottom boundary of the rectangular group
    while (x < land.length && land[x][b] == 1) {
        x++;
    }
    int bottom = x - 1;

    // Find the right boundary of the rectangular group
    while (y < land[0].length && land[a][y] == 1) {
        boolean validRow = true;
        for (int i = a; i <= bottom; i++) {
            if (land[i][y] != 1) {
                validRow = false;
                break;
            }
        }
        if (validRow) {
            y++;
        } else {
            break;
        }
    }
    int right = y - 1;

    // Mark the farmland as visited (set to 0)
    for (int i = a; i <= bottom; i++) {
        for (int j = b; j <= right; j++) {
            land[i][j] = 0;
        }
    }

    arr[0] = a;
    arr[1] = b;
    arr[2] = bottom;
    arr[3] = right;
    return arr;
}


    public int[][] findFarmland(int[][] land) {
         List<int[]> result = new ArrayList<>();
        for(int i=0; i<land.length;i++){
            for(int j=0; j<land[0].length;j++){
                if( land[i][j]==1 ){
                    result.add(search(land,i,j));
                }
            }
        }
         int[][] output = new int[result.size()][4];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }

        return output;
        
    }
}