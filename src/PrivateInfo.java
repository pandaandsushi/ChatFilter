import java.util.regex.*;

public class PrivateInfo {
    public static void filterPrivateInfo(String text) {
        System.out.println("CHECKING PRIVATE INFO...");
        boolean containsPhoneNumber = containsPhoneNumber(text);
        boolean containsEmailAddress = containsEmailAddress(text);
        boolean containsSocialMedia = containsSocialMedia(text);
        boolean containsOutsideLink = containsOutsideLink(text);
        boolean safe = true;

        if (containsPhoneNumber) {
            safe = false;
            System.out.println("The text contains a phone number: " + text);
        } 
        if (containsEmailAddress) {
            safe = false;
            System.out.println("The text contains an email address: " + text);
        } 
        else if (containsSocialMedia) {
            safe = false;
            System.out.println("The text contains a social media handle: " + text);
        } 
        if (containsOutsideLink) {
            safe = false;
            System.out.println("The text contains an outside link: " + text);
        } 
        if(safe) {
            System.out.println("The text does not contain prohibited information: " + text);
        }
    }

    // Regex pattern for matching phone numbers
    public static boolean containsPhoneNumber(String text) {
        String phonePattern = 
"(\\+62\\s?\\d{1,3}([-\\s]\\d{3,}([-\\s]\\d{4,})?)?)|(\\(\\d+\\)\\s?\\d+)|\\d{3}(\\s\\d+)+|\\d+([-\\s]\\d+)+|\\d{8,12}";

        Pattern compiledPattern = Pattern.compile(phonePattern);
        Matcher matcher = compiledPattern.matcher(text);
        return matcher.find();
    }

    // Regex pattern for matching email addresses 
    public static boolean containsEmailAddress(String text) {
        String emailPattern = "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}\\b";

        Pattern compiledPattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = compiledPattern.matcher(text);
        return matcher.find();
    }

    // Regex pattern for matching social media handles 
    public static boolean containsSocialMedia(String text) {
        String socmedPattern = "@[A-Za-z0-9_.]{3,25}";

        Pattern compiledPattern = Pattern.compile(socmedPattern);
        Matcher matcher = compiledPattern.matcher(text);
        return matcher.find();
    }

    // Regex pattern for matching links
    public static boolean containsOutsideLink(String text){
        String linkPattern = "\\b(https?|ftp)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]\\b";

        Pattern compiledPattern = Pattern.compile(linkPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = compiledPattern.matcher(text);
        return matcher.find();
    }

    public static void main(String[] args) {
        String[] texts = {
            "here is my phone (08xx)34567890",
            "s",
            "3",
            "08xx-3456-7890",
            "08xx 3456 7890",
            "(+62) 8xx34567890",
            "(+62) 8xx-3456-7890",
            "+628xx34567890",
            "+62-8xx-3456-7890",
            "+628xx 3456 7890",
            "random number 12345678",
            "random text with numbers 123 4567",
            "contact me at example@test.com",
            "my email is joh3n.doe@example.com",
            "w@gmail.com",
            "another_@invalid.email.@example.com",
            "visit my site at http://exa mple.com",
            "check this link: https://www.example.com/test",
            "follow me on @username"
        };

        for (String text : texts) {
            filterPrivateInfo(text);
        }
    }
}
