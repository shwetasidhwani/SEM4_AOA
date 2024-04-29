import java.util.Scanner;

public class rabinkarp {

    public static void rabinKarp(String txt, String pat, int q) {
        int d = 256; // Number of characters in the input alphabet
        int M = pat.length();
        int N = txt.length();
        int h = 1;

        // The value of h would be "pow(d, M-1)%q"
        for (int i = 0; i < M - 1; i++) {
            h = (h * d) % q;
        }

        // Calculate the hash value of pattern and first window of text
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        for (int i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (int i = 0; i <= N - M; i++) {
            // Check the hash values of current window of text and pattern.
            // If the hash values match then only check for characters one by one
            if (p == t) {
                boolean match = true;
                // Check for characters one by one
                for (int j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    System.out.println("Pattern found at index " + i);
                }
            }

            // Calculate hash value for next window of text: Remove leading digit, add
            // trailing digit
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
                // We might get negative value of t, converting it to positive
                if (t < 0) {
                    t = (t + q);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the text: ");
        String txt = scanner.nextLine();
        System.out.println("Enter the pattern to search: ");
        String pat = scanner.nextLine();
        System.out.println("Enter the prime number: ");
        int prime = scanner.nextInt();
        scanner.close();

        rabinKarp(txt, pat, prime);
    }
}
