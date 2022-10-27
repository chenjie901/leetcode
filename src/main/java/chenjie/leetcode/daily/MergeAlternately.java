package chenjie.leetcode.daily;

public class MergeAlternately {
    public String mergeAlternately(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; i < Math.min(chars1.length, chars2.length); i++) {
            sb.append(chars1[i]);
            sb.append(chars2[i]);
        }

        if (chars1.length > i) {
            sb.append(word1.substring(i));
        }

        if (chars2.length > i) {
            sb.append(word2.substring(i));
        }
        return sb.toString();
    }
}
