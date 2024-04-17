class Solution {
    private StringBuilder currentPath; // StringBuilder to store the current path from leaf to root.
    private String smallestPath; // String to keep track of the smallest path encountered.

    public String smallestFromLeaf(TreeNode root) {
        currentPath = new StringBuilder();
        // Initialize the smallest path with a string value greater than any possible leaf path.
        smallestPath = String.valueOf((char) ('z' + 1));
        // Start the depth-first search from the root.
        depthFirstSearch(root);
        // Return the smallest path from leaf to root.
        return smallestPath;
    }

    private void depthFirstSearch(TreeNode node) {
        if (node != null) {
            // Prepend the character representation of the current node's value to the path.
            currentPath.append((char) ('a' + node.val));
          
            // Check if it's a leaf node.
            if (node.left == null && node.right == null) {
                // Reverse the path to get the leaf to root string.
                String leafToRootPath = currentPath.reverse().toString();
              
                // Update the smallest path if the current path is smaller.
                if (leafToRootPath.compareTo(smallestPath) < 0) {
                    smallestPath = leafToRootPath;
                }
              
                // Reverse the path back to maintain the root to leaf order.
                currentPath.reverse();
            }
          
            // Continue the depth-first search to the left subtree.
            depthFirstSearch(node.left);
            // Continue the depth-first search to the right subtree.
            depthFirstSearch(node.right);
          
            // Backtrack: remove the last character representing the current node's value.
            currentPath.deleteCharAt(currentPath.length() - 1);
        }
    }
}