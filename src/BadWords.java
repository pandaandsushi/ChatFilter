import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
public class BadWords {
    public static void filterbadwords(String text, int algo) throws IOException{
        System.out.println("CHECKING BADWORDS...");
        // Membaca dictionary dari file badwords
        List<String> dictionary = Files.readAllLines(Paths.get("data/badwords.txt"));
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
                    System.out.println(">>> This word is not allowed: " + word);
                    break;
                }
            }
        }
    }

}
