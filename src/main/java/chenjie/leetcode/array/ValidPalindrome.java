//package chenjie.leetcode.array;
//
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class ValidPalindrome {
//
////    public boolean validPalindrome(String s) {
////        if (isPalidrome(s, 0, s.length() - 1)) {
////            return true
////        }
////        for (int i = 0; i < s.length(); i++) {
////
////        }
////    }
//
//    private boolean isPalidrome(String s, int l, int r) {
//        int i = l;
//        int j = r;
//        while (i < j) {
//            if(s.charAt(i++) != s.charAt(j--)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    @Test
//    public void test001() {
//        assertTrue(isPalidrome("aba"));
//        assertTrue(isPalidrome("abba"));
//        assertFalse(isPalidrome("abca"));
//    }
//}
