class Solution(object):
    def longestCommonPrefix(self,strs):
        # If the list of strings is empty, return an empty string
        if not strs:
            return ''
        # Iterate through the characters of the first string
        for i in range(len(strs[0])):
            # Iterate through the other strings in the list
            for string in strs[1:]:
                # If the index is out of range or the characters don't match, return the common prefix
                if i >= len(string) or string[i] != strs[0][i]:
                    # Return the common prefix
                    return strs[0][:i]
        # Return the first string if all characters match
        return strs[0]
        