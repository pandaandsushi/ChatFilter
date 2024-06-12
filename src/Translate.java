import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Translate {

    public static String translate(String input) {
        String numPattern = "[14630]";
        Pattern pattern = Pattern.compile(numPattern);
        Matcher matcher = pattern.matcher(input);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String replacement;
            switch (matcher.group()) {
                case "1":
                    replacement = "i";
                    break;
                case "4":
                    replacement = "a";
                    break;
                case "6":
                    replacement = "g";
                    break;
                case "5":
                    replacement = "s";
                    break;
                case "3":
                    replacement = "e";
                    break;
                case "0":
                    replacement = "o";
                    break;
                default:
                    replacement = matcher.group();
                    break;
            }
            matcher.appendReplacement(result, replacement);
        }
        matcher.appendTail(result);

        String translated = result.toString().toLowerCase();

        return translated.toString();
    }

}
