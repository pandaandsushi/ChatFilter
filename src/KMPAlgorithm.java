// KMP ALGORITHM

// function to build LPS / border func table in KMP  
// will return an array of border func
public class KMPAlgorithm {
    // function to build LPS / border func table in KMP  
    // will return an array of border func
    public static int[] lpsValue(String pattern) {
        int[] borderfunc = new int[pattern.length()];
        int prefixbestlength = 0;
        int idx = 1; // the lps array index starts from 1 since borderfunc[0] is always 0
        borderfunc[0] = 0; // when j = 0 we always get border func 0
        
        while (idx < pattern.length()) {
            if (pattern.charAt(idx) == pattern.charAt(prefixbestlength)) {
                prefixbestlength++;
                borderfunc[idx] = prefixbestlength;
                idx++;
            } else {
                if (prefixbestlength > 0) { // based on matching prefix
                    prefixbestlength = borderfunc[prefixbestlength - 1];
                } else { // no match
                    borderfunc[idx] = 0;
                    idx++;
                }
            }
        }
        return borderfunc;
    }

    // main KMP algo that will return the idx found on text
    public static int KMPAlgo(String pattern, String text) {
        int n = text.length();
        int m = pattern.length();
        int[] borderfunc = lpsValue(pattern);
        
        // initialize starting mismatch index
        int idx_i = 0;
        int idx_j = 0;
        
        while (idx_i < n) {
            if (pattern.charAt(idx_j) == text.charAt(idx_i)) {
                if (idx_j == m - 1) {
                    return idx_i - m + 1;
                }
                idx_i++;
                idx_j++;
            } else {
                if (idx_j > 0) {
                    idx_j = borderfunc[idx_j - 1];
                } else {
                    idx_i++;
                }
            }
        }
        return -1; 
    }
}
