public class BFAlgorithm {
    public static int BFAlgo(String text, String pattern){
        int n = text.length();
        int m = pattern.length();
        int idxfound = -1;
        for (int i = 0; i<=n-m; i++){
            int countsame = 0;
            for (int j = 0; j<m; j++){
                if (pattern.charAt(j)!=text.charAt(i+j)){
                    break;
                }    
                countsame++;
            }
            if(countsame==m){
                idxfound = i;
                break;
            }
        }
        return idxfound;
    }
}
