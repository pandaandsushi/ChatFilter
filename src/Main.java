import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean stop = false;
        System.out.println("Welcome to Chat Filter!");
        System.out.println("Here we are going to determine if your chat violates our rule:");
        System.out.println("- no vulgar words");
        System.out.println("- intention to ask customer to cancel an order");
        System.out.println("- sharing private information that could lead to dangerous out of app transaction");
        System.out.println("");

        Scanner scanner = new Scanner(System.in);

        while (!stop) {
            System.out.println("-----------------------------------------------------");
            System.out.println("Enter a text message to check: ");
            String message = scanner.nextLine();
            System.out.println("");
            int algo = 0;
            while (true) {
                System.out.println("Choose your algorithm (KMP/BM/BF):");
                System.out.print(">> ");
                String optalgo = scanner.nextLine();
                if (optalgo.equalsIgnoreCase("KMP")){
                    break; 
                } else if (optalgo.equalsIgnoreCase("BM")){
                    algo = 1;
                    break;
                } else if (optalgo.equalsIgnoreCase("BF")){
                    algo = 2;
                    break;
                } else {
                    System.out.println("Wrong input.");
                }
            }
            long startTime, endTime, elapsedTime;
            startTime = System.currentTimeMillis();
            try {
                chatfilter(message, algo);
            } catch (IOException e) {
                e.printStackTrace();
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            if(algo == 0){
                System.out.println("KMP Execution Time: " + elapsedTime + " ms");
            }
            else if (algo == 1){
                System.out.println("BM Execution Time: " + elapsedTime + " ms");
            }
            else{
                System.out.println("BF Execution Time: " + elapsedTime + " ms");
            }
            System.out.println("-----------------------------------------------------");

            while (true) {
                System.out.println("Do you want to try again? (Y/N)");
                System.out.print(">> ");
                String yn = scanner.nextLine();
                if (yn.equalsIgnoreCase("N")) {
                    stop = true;
                    break;
                } else if (!yn.equalsIgnoreCase("Y")) {
                    System.out.println("Wrong input.");
                } else {
                    break;
                }
            }
        }
        scanner.close();
        System.out.println("Goodbye, thanks for trying chat filter!");
    }

    public static void chatfilter(String message, int algo) throws IOException {
        String altermessage = Translate.translate(message);
        
        System.out.println("-----------------------------------------------------");
        // Check for bad words
        BadWords.filterbadwords(altermessage, algo);
        System.out.println("-----------------------------------------------------");
        // Check for cancelling
        Cancel.filtercancel(altermessage, algo);
        System.out.println("-----------------------------------------------------");
        // Check for private information
        PrivateInfo.filterPrivateInfo(message);
    }
}
