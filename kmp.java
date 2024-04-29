import java.util.*;

public class kmp {
    static void LPS_Search(String pattern, int M, int[] lps) { // pattern is small part which needs to be found in
                                                               // target text
        int len = 0;
        lps[0] = 0;
        int i = 1;
        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    static void KMP_Search(String text, String pattern) {
        int n = text.length(); // length of entire text
        int m = pattern.length(); // length of smaller pattern
        int[] lps = new int[m];
        LPS_Search(pattern, m, lps);
        int i = 0;
        int j = 0;
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            } else {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
            if (j == m) {
                System.out.println("Pattern found at index: " + (i - j));
                j = lps[j - 1];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text: ");
        String txt = sc.nextLine();
        System.out.println("Enter the pattern: ");
        String pat = sc.nextLine();
        KMP_Search(txt, pat);
        sc.close();
    }
}
