class Solution {

    public void assign(char A, char B, int[] charValue) {

        int changeTo = charValue[B - 'a'];
            for (int i = 0; i < charValue.length; i++) {
                if (charValue[i] == changeTo) {
                    charValue[i] = charValue[A - 'a'];
                }
            }

    }

    public boolean equationsPossible(String[] equations) {

        int[] charValue = new int[26];

        for (int i = 0; i < charValue.length; i++) {
            charValue[i] = i;
        }

        for (String s : equations) {
            if (s.charAt(1) == '=') {
                assign(s.charAt(0), s.charAt(3), charValue);
            }
        }

        for (String s : equations) {
            if (s.charAt(1) == '!') {
                if (charValue[s.charAt(0) - 'a'] == charValue[s.charAt(3) - 'a']) {
                    return false;
                }
            }
        }

        return true;

    }
}