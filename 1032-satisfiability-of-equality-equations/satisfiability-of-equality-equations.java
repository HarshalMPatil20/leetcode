class Solution {

    public void assign(char A, char B, int[] charValue) {

        if (charValue[A - 'a'] == A - 'a') {
            int changeTo = charValue[B - 'a'];
            for (int i = 0; i < charValue.length; i++) {
                if (charValue[i] == changeTo) {
                    System.out.println("changeTo: " + changeTo);
                    charValue[i] = charValue[A - 'a'];
                    System.out.println("i: " + i + " charValue[A - 'a']: " + charValue[A - 'a']);
                }
            }

        } else {
            int changeTo = charValue[B - 'a'];
            for (int i = 0; i < charValue.length; i++) {
                if (charValue[i] == changeTo) {
                    charValue[i] = charValue[A - 'a'];
                }
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
                if (s.charAt(0) < s.charAt(3)) {
                    assign(s.charAt(0), s.charAt(3), charValue);
                } else {
                    assign(s.charAt(3), s.charAt(0), charValue);
                }
                for (int i : charValue) {
                    System.out.print(i + " ");
                }

            }

            System.out.println();
        }

        for (String s : equations) {
            if (s.charAt(1) == '!') {
                if (charValue[s.charAt(0) - 'a'] == charValue[s.charAt(3) - 'a']) {
                    return false;
                }
            }
        }

        for (int i : charValue) {
            System.out.print(i + " ");
        }

        return true;

    }
}