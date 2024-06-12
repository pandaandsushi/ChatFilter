import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
public class Cancel {
    public static void filtercancel(String text, int algo) throws IOException{
        // Membaca dictionary dari file cancel
        System.out.println("CHECKING CANCEL...");
        List<String> dictionary = Files.readAllLines(Paths.get("data/cancel.txt"));
        if (algo == 0){
            // Use KMP
            for (String word : dictionary) {
                if (KMPAlgorithm.KMPAlgo(word, text)!=-1) {
                    System.out.println("This word is not allowed: " + word);
                    break;
                }
            }
        }
        else if (algo == 1){ 
            // Use BM
            for (String word : dictionary) {
                if (BMAlgorithm.BMAlgo(word, text)!=-1) {
                    System.out.println("This word is not allowed: " + word);
                    break;
                }
            }
        }
        else{
            // Use BF
            for (String word : dictionary) {
                if (BFAlgorithm.BFAlgo(word, text)!=-1) {
                    System.out.println("This word is not allowed: " + word);
                    break;
                }
            }
        }
    }
}
