package chenjie.leetcode.daily;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = common(prefix, strs[i]);
            if (prefix == "") {
                return "";
            }
        }
        return prefix;
    }

    public String common(String str1, String str2) {
        int n = Math.min(str2.length(), str1.length());
        int i = 0;
        for (;i  < n; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
        }
        return str1.substring(0, i +1);
    }
}
