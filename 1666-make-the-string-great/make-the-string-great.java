class Solution {

  public boolean isBadPair(char a, char b) {
    return a != b && Character.toLowerCase(a) == Character.toLowerCase(b);
  }

  public String makeGood(String s) {

    StringBuilder stringbuilder = new StringBuilder();

    for (char c : s.toCharArray())

      if (stringbuilder.length() > 0 && isBadPair(stringbuilder.charAt(stringbuilder.length() - 1),  c))
        stringbuilder.deleteCharAt(stringbuilder.length() - 1);

      else
        stringbuilder.append(c);

    return stringbuilder.toString();
  }

}