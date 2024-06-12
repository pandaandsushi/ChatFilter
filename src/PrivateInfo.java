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
        }
        if (containsEmailAddress) {
            safe = false;
        }
        else if (containsSocialMedia) {
            safe = false;
        }
        if (containsOutsideLink) {
            safe = false;
        }
        if (safe) {
            System.out.println("The text does not contain prohibited information: " + text);
        }
    }

    // Regex pattern for matching phone numbers
    public static boolean containsPhoneNumber(String text) {
        String phonePattern =
                "(\\+62\\s?\\d{1,3}([-\\s]\\d{3,}([-\\s]\\d{4,})?)?)|(\\(\\d+\\)\\s?\\d+)|\\d{3}(\\s\\d+)+|\\d+([-\\s]\\d+)+|\\d{8,12}";

        Pattern compiledPattern = Pattern.compile(phonePattern);
        Matcher matcher = compiledPattern.matcher(text);
        if (matcher.find()) {
            System.out.println("The text contains a phone number: " + matcher.group());
            return true;
        }
        return false;
    }

    // Regex pattern for matching email addresses
    public static boolean containsEmailAddress(String text) {
        String emailPattern = "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}\\b";

        Pattern compiledPattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = compiledPattern.matcher(text);
        if (matcher.find()) {
            System.out.println("The text contains an email address: " + matcher.group());
            return true;
        }
        return false;
    }

    // Regex pattern for matching social media handles
    public static boolean containsSocialMedia(String text) {
        String socmedPattern = "@[A-Za-z0-9_.]{3,25}";

        Pattern compiledPattern = Pattern.compile(socmedPattern);
        Matcher matcher = compiledPattern.matcher(text);
        if (matcher.find()) {
            System.out.println("The text contains a social media handle: " + matcher.group());
            return true;
        }
        return false;
    }

    // Regex pattern for matching links
    public static boolean containsOutsideLink(String text) {
        String linkPattern = "\\b(https?|ftp)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]\\b";

        Pattern compiledPattern = Pattern.compile(linkPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = compiledPattern.matcher(text);
        if (matcher.find()) {
            System.out.println("The text contains an outside link: " + matcher.group());
            return true;
        }
        return false;
    }

}