// BM ALGORITHM

// function to build lastoccurence table
// will return array of lasttoccur
public class BMAlgorithm {
    public static int[] lastoccur(String pattern){
        int lastoccur[] = new int[128];
        for (int i = 0; i<128; i++){
            lastoccur[i] = -1;  //every char doesnt exist at first
        }
        for (int i = 0; i<pattern.length(); i++){
            lastoccur[pattern.charAt(i)] = i;
        }
        return lastoccur;
    }
    
    // main algo of BM
    public static int BMAlgo(String pattern, String text){
        int n = text.length();
        int m = pattern.length();
        int lastoccur[] = lastoccur(pattern);
        int idx_i = m-1;
        int idx_j = m-1;
        
        while (idx_i<=n-1) {
            if(pattern.charAt(idx_j)==text.charAt(idx_i)){
                if(idx_j==0){
                    return idx_i;
                }
                else{
                    idx_i--;
                    idx_j--;
                }
            }
            else{
                int lo = lastoccur[text.charAt(idx_i)];
                idx_i = idx_i+m-Math.min(idx_j, 1+lo);
                idx_j = m-1;
            }
        }
        return -1;
    }
}