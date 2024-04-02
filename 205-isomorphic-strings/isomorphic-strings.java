class Solution {
    public boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        Map<Character,Character> hashmap = new HashMap <> ();

        for (int i = 0; i < s.length(); i++) {

            char s_char = s.charAt(i);
            char t_char = t.charAt(i);

            if (!hashmap.containsKey(s_char)) {
                if (!hashmap.containsValue(t_char))
                hashmap.put(s_char, t_char);
                else
                return false;
            }
            else {
                if (hashmap.get(s_char) != t_char)
                return false;
            }
        }
    return true;
    }
}





  